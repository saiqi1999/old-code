package com.ruoyi.hr.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bstek.uflo.model.ProcessInstance;
import com.bstek.uflo.model.task.Task;
import com.bstek.uflo.model.task.TaskState;
import com.bstek.uflo.service.HistoryService;
import com.bstek.uflo.service.ProcessService;
import com.bstek.uflo.service.StartProcessInfo;
import com.bstek.uflo.service.TaskOpinion;
import com.bstek.uflo.service.TaskService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.hr.domain.HrRecruit;
import com.ruoyi.hr.service.IHrRecruitService;
import com.ruoyi.system.domain.SysPost;
import com.ruoyi.system.service.ISysPostService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 招聘申请Controller
 * 
 * @author zy
 * @date 2019-08-29
 */
@Controller
@RequestMapping("/hr/recruit")
public class HrRecruitController extends BaseController {
	private String prefix = "hr/recruit";

	@Autowired
	private ISysUserService userService;


	@Autowired
	private ISysPostService postService;

	@Autowired
	private ProcessService processService;

	@Autowired
	private HistoryService historyService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private IHrRecruitService hrRecruitService;

	@RequiresPermissions("hr:recruit:view")
	@GetMapping()
	public String recruit() {
		return prefix + "/recruit";
	}

	/**
	 * 查询招聘申请列表
	 */
	@RequiresPermissions("hr:recruit:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HrRecruit hrRecruit) {
		startPage();
		List<HrRecruit> list = hrRecruitService.selectHrRecruitList(hrRecruit);
		return getDataTable(list);
	}

	/**
	 * 导出招聘申请列表
	 */
	@RequiresPermissions("hr:recruit:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(HrRecruit hrRecruit) {
		List<HrRecruit> list = hrRecruitService.selectHrRecruitList(hrRecruit);
		ExcelUtil<HrRecruit> util = new ExcelUtil<HrRecruit>(HrRecruit.class);
		return util.exportExcel(list, "recruit");
	}

	/**
	 * 新增招聘申请
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}

	/**
	 * 新增保存招聘申请
	 */
	@RequiresPermissions("hr:recruit:add")
	@Log(title = "招聘申请", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HrRecruit hrRecruit) {

		hrRecruit.setStatus("0");
		return toAjax(hrRecruitService.insertHrRecruit(hrRecruit));
	}

	/**
	 * 修改招聘申请
	 */
	@GetMapping("/edit/{recruitId}")
	public String edit(@PathVariable("recruitId") Long recruitId, ModelMap mmap) {
		HrRecruit hrRecruit = hrRecruitService.selectHrRecruitById(recruitId);
		mmap.put("hrRecruit", hrRecruit);
		return prefix + "/edit";
	}

	/**
	 * 修改保存招聘申请
	 */
	@RequiresPermissions("hr:recruit:edit")
	@Log(title = "招聘申请", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HrRecruit hrRecruit) {
		return toAjax(hrRecruitService.updateHrRecruit(hrRecruit));
	}

	/**
	 * 删除招聘申请
	 */
	@RequiresPermissions("hr:recruit:remove")
	@Log(title = "招聘申请", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(hrRecruitService.deleteHrRecruitByIds(ids));
	}

	/**
	 * 启动并提交流程
	 */
	@RequiresPermissions("oa:leave:edit")
	// @Log(title = "启动招聘申请流程", businessType = BusinessType.UPDATE)
	@GetMapping("/start/{recruitId}")
	@ResponseBody
	public AjaxResult start(@PathVariable("recruitId") Long recruitId) {
		List<SysPost> posts = postService.selectPostsByUserId(ShiroUtils.getUserId());
		int position = 1;
		for (SysPost sysPost : posts) {
			if (sysPost.getPostId() != 2) {
				position = 0;
				break;
			}
		}

		SysUser tempUser = new SysUser();
		tempUser.setDeptId(ShiroUtils.getSysUser().getDeptId());
		tempUser.setRoleId(3L);
		List<SysUser> templist = userService.selectUserList(tempUser);
		List<String> users = new ArrayList<String>();
		for (int i = 0; i < templist.size(); i++) {
			users.add(templist.get(i).getLoginName().toString());
		}
		if (!users.contains(ShiroUtils.getSysUser().getDept().getLeader())) {
			users.add(ShiroUtils.getSysUser().getDept().getLeader());
		}
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("position", position);
		variables.put("users", users);
		StartProcessInfo startProcessInfo = new StartProcessInfo("admin");
		startProcessInfo.setSubject(ShiroUtils.getSysUser().getUserName() + "发起的招聘申请");
		startProcessInfo.setBusinessId("/hr/recruit:" + recruitId);
		// startProcessInfo.setCompleteStartTask(flase);
		startProcessInfo.setCompleteStartTaskOpinion("发起流程");
		startProcessInfo.setVariables(variables);
		ProcessInstance processInstance = processService.startProcessByName("招聘申请", startProcessInfo);
		HrRecruit hrRecruit = hrRecruitService.selectHrRecruitById(recruitId);
		hrRecruit.setStatus("1");
		hrRecruit.setProcessInstanceId(String.valueOf(processInstance.getId()));
		hrRecruit.setUpdateBy(ShiroUtils.getLoginName());
		hrRecruit.setUpdateTime(DateUtils.getNowDate());
		int result = hrRecruitService.updateHrRecruit(hrRecruit);
		return result > 0 ? success("流程已启动并提交！") : error("流程出错，请联系管理员！");
	}

	/**
	 * 流程详情
	 */
	@GetMapping("/detail/{processInstanceId}")
	public String detail(@PathVariable("processInstanceId") Long processInstanceId, ModelMap mmap) {
		String businessId = historyService.getHistoryProcessInstance(processInstanceId).getBusinessId()
				.split(":")[1];
		HrRecruit hrRecruit = hrRecruitService.selectHrRecruitById(Long.valueOf(businessId));
		mmap.put("hrRecruit", hrRecruit);
		return prefix + "/detail";
	}

	/**
	 * 办理审批流程
	 */
	@GetMapping("/approve")
	public String approve(HttpServletRequest request, ModelMap mmap) {
		Long taskId = (Long) request.getAttribute("taskId");
		// String assignee = taskService.getTask(taskId).getAssignee();
		HrRecruit hrRecruit = hrRecruitService
				.selectHrRecruitById(Long.valueOf(request.getAttribute("businessID").toString()));
		mmap.put("hrRecruit", hrRecruit);
		mmap.put("taskId", taskId);
		String isflag = "true";
		String nodeName = taskService.getTask(taskId).getNodeName();
		if (nodeName.equals("开始")) {
			isflag = "false";
		}
		mmap.put("isflag", isflag);
		return prefix + "/approve";
	}

	/**
	 * 办理审批请假流程,同意后保存并提交
	 */
	@PostMapping("/approve")
	@ResponseBody
	public AjaxResult approveSave(HrRecruit hrRecruit) {

		Long taskId = hrRecruit.getTaskId();
		String comment = hrRecruit.getComment();
		Map<String, Object> variables = new HashMap<String, Object>();
		TaskState taskstate = taskService.getTask(taskId).getState();
		if (taskstate.name().equals("Created") || taskstate.name().equals("Reserved")) {
			taskService.start(taskId);
		}
		taskService.complete(taskId, variables, new TaskOpinion(comment));
		long processInstanceId = historyService.getHistoryTask(taskId).getProcessInstanceId();
		// 获取下一个任务
		List<Task> list = taskService.createTaskQuery().processInstanceId(processInstanceId).list();
		if (list.size() == 0) {
			hrRecruit.setStatus("2");
		}
		hrRecruit.setProcessInstanceId(String.valueOf(processInstanceId));
		hrRecruit.setUpdateBy(ShiroUtils.getLoginName());
		hrRecruit.setUpdateTime(DateUtils.getNowDate());
		int result = hrRecruitService.updateHrRecruit(hrRecruit);
		return result > 0 ? success("已成功提交到下一步") : error("流程出错，请联系管理员！");
	}

	/**
	 * 驳回到上一步,保存并提交
	 */
	@PostMapping("/rollback")
	@ResponseBody
	public AjaxResult rollback(HrRecruit hrRecruit) {

		Long taskId = hrRecruit.getTaskId();
		String comment = hrRecruit.getComment();
		Task task = taskService.getTask(taskId);
		String pretask = task.getPrevTask();
		Map<String, Object> variables = new HashMap<String, Object>();
		taskService.rollback(taskId, pretask, variables, new TaskOpinion(comment));
		hrRecruit.setUpdateBy(ShiroUtils.getLoginName());
		hrRecruit.setUpdateTime(DateUtils.getNowDate());
		int result = hrRecruitService.updateHrRecruit(hrRecruit);
		return result > 0 ? success("已驳回到上一步") : error("流程出错，请联系管理员！");
	}

	/**
	 * 驳回到开始节点,保存并提交
	 */
	@PostMapping("/backstart")
	@ResponseBody
	public AjaxResult backstart(HrRecruit hrRecruit) {

		Long taskId = hrRecruit.getTaskId();
		String comment = hrRecruit.getComment();
		Map<String, Object> variables = new HashMap<String, Object>();
		taskService.rollback(taskId, "开始", variables, new TaskOpinion(comment));
		hrRecruit.setUpdateBy(ShiroUtils.getLoginName());
		hrRecruit.setUpdateTime(DateUtils.getNowDate());
		int result = hrRecruitService.updateHrRecruit(hrRecruit);
		return result > 0 ? success("已驳回到开始节点") : error("流程出错，请联系管理员！");
	}

}
