package com.ruoyi.hrm.controller;

import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.hrm.domain.HrmMessage;
import com.ruoyi.hrm.service.IHrmMessageService;
import com.ruoyi.system.domain.SysAttachment;
import com.ruoyi.system.service.ISysAttachmentService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 站内信箱Controller 基础原理：信件送出后分成两份copy，一份是收件人的，一份是发件人的，存入两个不同的表，分开管理实现异步删除、查阅信件。
 * 从最底层的mapper到service，serviceimpl，controller，前端弹出界面view都分成两份，复用率较低。
 * 如果从底层domain修改，添加额外属性，使用一个数据表管理信息，可以提高复用率，方便修改。但是hrm本身系统固定，修改的情况不多。
 * 
 * @author ruoyi
 * @date 2021-05-19
 */
@Controller
@RequestMapping("/hrm/message")
public class HrmMessageController extends BaseController {
	private String prefix = "hrm/message";

	@Autowired
	private IHrmMessageService hrmMessageService;

	@Autowired
	private ISysUserService SysUserService;
	
	@Autowired
	private ISysAttachmentService SysAttachmentService;
	/*
	 * @RequiresPermissions("hrm:message:view")
	 * 
	 * @GetMapping() public String message() { return prefix + "/message"; }
	 */

	@RequiresPermissions("hrm:message:view")
	@GetMapping("/receive")
	public String receive() {
		return prefix + "/receive";
	}

	@RequiresPermissions("hrm:message:view")
	@GetMapping("/send")
	public String send() {
		return prefix + "/send";
	}

	/**
	 * 查询站内信箱列表
	 */
	@RequiresPermissions("hrm:message:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HrmMessage hrmMessage) {
		startPage();
		String username = SysUserService.selectUserByLoginName(ShiroUtils.getLoginName()).getUserName();
		hrmMessage.setUserReceive(username);
		List<HrmMessage> list = hrmMessageService.selectHrmMessageList(hrmMessage);
		return getDataTable(list);
	}

	/**
	 * 发信箱
	 * 
	 * @param hrmMessage
	 * @return
	 */
	@RequiresPermissions("hrm:message:list")
	@PostMapping("/send")
	@ResponseBody
	public TableDataInfo send(HrmMessage hrmMessage) {
		startPage();
		String username = SysUserService.selectUserByLoginName(ShiroUtils.getLoginName()).getUserName();
		hrmMessage.setUserSend(username);
		List<HrmMessage> list = hrmMessageService.selectHrmMessageList2(hrmMessage);
		//System.out.println(list);
		return getDataTable(list);

	}

	/**
	 * 导出站内信箱列表
	 */
	@RequiresPermissions("hrm:message:export")
	@Log(title = "站内信箱", businessType = BusinessType.EXPORT)
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(HrmMessage hrmMessage) {
		List<HrmMessage> list = hrmMessageService.selectHrmMessageList(hrmMessage);
		ExcelUtil<HrmMessage> util = new ExcelUtil<HrmMessage>(HrmMessage.class);
		return util.exportExcel(list, "站内信箱数据");
	}

	/**
	 * 新增站内信箱
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}

	/**
	 * 新增保存站内信箱
	 */
	@RequiresPermissions("hrm:message:add")
	@Log(title = "站内信箱", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HrmMessage hrmMessage) {
		hrmMessage.setUserSend(SysUserService.selectUserByLoginName(ShiroUtils.getLoginName()).getUserName());
		hrmMessage.setRead("未读");
		String s = hrmMessage.getUserReceive();
		String r = "";
		for (String i : s.split(",")) {
			if (i != "") {
				hrmMessage.setUserReceive(i);
				hrmMessageService.insertHrmMessage2(hrmMessage);
				hrmMessageService.insertHrmMessage(hrmMessage);
				r+=hrmMessage.getMessageId()+",";
			}
		}
		AjaxResult rst = new AjaxResult();
		rst.put("code", 0);
		rst.put("businessId", r);
		System.out.println(hrmMessage.toString());
		rst.put("msg", "操作成功");
		return rst;
	}

	/**
	 * 批量保存附件
	 */
	@PostMapping("/save")
	@ResponseBody
	public AjaxResult save(SysAttachment sysAttachment) {
		System.out.println("批量保存");
		sysAttachment.setCreateBy(ShiroUtils.getLoginName());
		//这里直接从后台调用函数吧
		//System.out.println(sysAttachment.toString());
		String r = sysAttachment.getBusinessId();
		for(String i : r.split(",")) {
			if(i!="") {
				sysAttachment.setBusinessId(i);
				SysAttachmentService.insertSysAttachment(sysAttachment);
			}
		}
		return success("good");
	}
	
	/**
	 * 
	 * @param messageId
	 * @param mmap
	 * @return
	 */
	@GetMapping("/view/{messageId}")
	public String view(@PathVariable("messageId") Long messageId, ModelMap mmap) {
		HrmMessage hrmMessage = hrmMessageService.selectHrmMessageById(messageId);
		mmap.put("hrmMessage", hrmMessage);
		return prefix + "/view";
	}

	/**
	 * 
	 * @param messageId
	 * @param mmap
	 * @return
	 */
	@GetMapping("/view2/{messageId}")
	public String view2(@PathVariable("messageId") Long messageId, ModelMap mmap) {
		HrmMessage hrmMessage = hrmMessageService.selectHrmMessageById2(messageId);
		mmap.put("hrmMessage", hrmMessage);
		return prefix + "/view2";
	}

	/**
	 * 修改站内信箱
	 *//*
		 * @GetMapping("/edit/{messageId}") public String
		 * edit(@PathVariable("messageId") Long messageId, ModelMap mmap) { HrmMessage
		 * hrmMessage = hrmMessageService.selectHrmMessageById(messageId);
		 * mmap.put("hrmMessage", hrmMessage); return prefix + "/edit"; }
		 */

	/**
	 * 修改保存站内信箱
	 */
	@RequiresPermissions("hrm:message:edit")
	@Log(title = "站内信箱", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HrmMessage hrmMessage) {
		hrmMessage.setReadTime(new Date());
		hrmMessage.setRead("已读");
		hrmMessageService.updateHrmMessage2(hrmMessage);
		//System.out.println(hrmMessageService.selectHrmMessageList2(hrmMessage));
		return toAjax(hrmMessageService.updateHrmMessage(hrmMessage));
	}

	/**
	 * 修改保存站内信箱
	 */
	/*
	 * @RequiresPermissions("hrm:message:edit")
	 * 
	 * @Log(title = "站内信箱", businessType = BusinessType.UPDATE)
	 * 
	 * @PostMapping("/edit2")
	 * 
	 * @ResponseBody public AjaxResult editSave2(HrmMessage hrmMessage) { return
	 * toAjax(hrmMessageService.updateHrmMessage2(hrmMessage)); }
	 */

	/**
	 * 删除站内信箱
	 */
	@RequiresPermissions("hrm:message:remove")
	@Log(title = "站内信箱", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(hrmMessageService.deleteHrmMessageByIds(ids));
	}

	/**
	 * 删除站内信箱
	 */
	@RequiresPermissions("hrm:message:remove")
	@Log(title = "站内信箱", businessType = BusinessType.DELETE)
	@PostMapping("/remove2")
	@ResponseBody
	public AjaxResult remove2(String ids) {
		return toAjax(hrmMessageService.deleteHrmMessageByIds2(ids));
	}
}
