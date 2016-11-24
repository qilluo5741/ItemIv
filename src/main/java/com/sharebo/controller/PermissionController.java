package com.sharebo.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sharebo.entity.Result;
import com.sharebo.entity.UserInfo;
import com.sharebo.entity.dto.RoleInfo;
import com.sharebo.service.PermissionService;
import com.sharebo.util.MD5Util;

/**
 * Ȩ��ģ��
 * @author niewei
 *
 */
@Controller
@RequestMapping("permission")
public class PermissionController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private PermissionService service;

	// ��ɫ����-��ѯ**********************
	@RequestMapping("/roleManagerView")
	public String roleManagerView(ModelMap model, HttpSession session) {
		// �õ��û�
		UserInfo user = (UserInfo) session.getAttribute("user");
		if (user == null) {// �û���½��ʱ
			return "login";
		}
		// �ж��û��Ƿ��ǳ���������ҵ��
		if (user.getIsProperty() != 1) {
			return "login";
		}
		// �����û������õ��û������
		List<RoleInfo> roles = service.getRolesByUserId(user.getUserId());
		model.addAttribute("roles", roles);
		//�����־��
		log.warn(user.getUserAccount()+":�û������˽�ɫ��ѯ��");
		return "RoleInfoManager";
	}

	// ��ӽ�ɫ
	@RequestMapping("addRole")
	@ResponseBody
	public Result addRole(String roleName, HttpSession session)
			throws Exception {
		roleName = roleName.trim();
		// ��֤�����Ƿ�Ϸ�
		if (roleName == null || roleName.equals("")) {
			return new Result(1002, "��ɫ���ֲ���Ϊ�գ�");
		}
		// ��֤��ɫ�Ƿ��Ѿ�����
		// �õ��û�
		UserInfo user = (UserInfo) session.getAttribute("user");
		if (user == null) {// �û���½��ʱ
			throw new Exception("��½��ʱ�������µ�½��");
		}
		// �ж��û��Ƿ��Ǹ�Ȩ��
		if (user.getIsProperty() != 1) {
			throw new Exception("�����쳣��");
		}
		// ��֤��ɫ�Ƿ��Ѿ�����
		if (service.getRoleCount(user.getUserId(), roleName) > 0) {
			return new Result(1003, "��" + roleName + "����ɫ�����Ѿ�����,�����ظ���ӣ�");
		}
		RoleInfo role = new RoleInfo();
		role.setRoleId(UUID.randomUUID().toString().replace("-", ""));
		role.setUserId(user.getUserId());
		role.setRoleName(roleName);
		// ��ӽ�ɫ
		if (service.addRole(role) > 0) {
			//�����־��
			log.warn(user.getUserAccount()+":�û���ӽ�ɫ�ɹ�����ɫ�����ǣ�"+roleName);
			// ��ӳɹ���
			return new Result(200, "��ӳɹ�", role);
		} else {
			//�����־��
			log.error(user.getUserAccount()+":�û���ӽ�ɫʧ�ܣ���ɫ�����ǣ�"+roleName);
			// ���ʧ�ܣ�
			return new Result(1004, "���ʧ�ܣ�");
		}
	}

	// ɾ����ɫ
	@RequestMapping("deleteRole")
	@ResponseBody
	public Result deleteRole(HttpSession session, String roleId)
			throws Exception {
		roleId = roleId.trim();
		// �õ��û�
		UserInfo user = (UserInfo) session.getAttribute("user");
		// ��֤��ɫId�Ƿ�Ϸ�
		if (roleId == null || roleId.equals("")) {
			throw new Exception("�����쳣��");
		}
		// ��֤��ǰ��ɫ�����Ƿ����û�
		if (service.getUserCountByRoleId(roleId) > 0) {// ��ɫ��������û�
			return new Result(1005, "�ý�ɫ�°����û��������ɾ���ý�ɫ������ɾ���û���");
		}
		
		// ɾ����ɫ���޸Ľ�ɫ״̬��
		if (service.updateRoleIsDeleteByRoleId(roleId) > 0) {// ɾ���ɹ�
			//�����־��
			log.warn(user.getUserAccount()+":�û�ɾ����ɫ�ɹ���");
			return new Result(200, "�޸ĳɹ���");
		}
		log.error(user.getUserAccount()+":ɾ����ɫʧ�ܣ�");
		return new Result(1006, "�޸�ʧ�ܣ�");
	}
	//�޸Ľ�ɫ
	@RequestMapping("updateRoleName")
	@ResponseBody
	public Result updateRoleName(String roleId,String roleName,HttpSession session){
		//�õ��û�
		UserInfo user = (UserInfo) session.getAttribute("user");
		//�û�userIdȥ��ѯ�Ƿ���ڵ�ǰ��ɫ����
		if(service.getRoleCount(user.getUserId(), roleName)>0){//��ɫ�����Ѿ�����
			return new Result(1007, "��ǰ��ɫ�����Ѿ����ڣ�");
		}
		//���Ľ�ɫ����
		if(service.updateRoleNameByroleId(roleId, roleName)>0){//�޸ĳɹ�
			log.warn(user.getUserAccount()+":�޸ĳɹ��ܣ�");
			return new Result(200,"�޸ĳɹ���");
		}
		log.error(user.getUserAccount()+":�޸�ʧ�ܣ�");
		return new Result(1008, "�޸�ʧ�ܣ�");
	}
	
	//��ɫ�˵���ѯ
	@RequestMapping("RoleMenuView")//http://localhost:8080/shareboManager/permission/RoleMenuView.do?roleId=r111
	public String RoleMenuView(ModelMap model,String roleId,HttpSession session) throws Exception{
		//�õ��û�
		UserInfo user = (UserInfo) session.getAttribute("user");
		if (user == null) {// �û���½��ʱ
			return "login";
		}
		//��֤��ɫ�Ƿ��ǵ�ǰ�û���
		if(service.valRoleUserIsExists(roleId, user.getUserId())==0){
			throw new Exception("�����쳣��");
		}
		//��ѯ��ɫ��ѡ��Ĳ˵���δѡ��Ĳ˵�
		model.addAttribute("ok_menus", service.getExistsMenusByRoleId(roleId));
		model.addAttribute("no_menus", service.getNotExistsMenusByRoleId(roleId));
		model.addAttribute("roleId", roleId);
		return "RoleMenuManger";
	}
	//����˵�
	@RequestMapping("addMenu")
	public @ResponseBody Result addMenu(String roleId,String menuId,HttpSession session) throws Exception{
		//�õ��û�
		UserInfo user = (UserInfo) session.getAttribute("user");
		if (user == null) {// �û���½��ʱ
			throw new Exception("��½��ʱ��");
		}
		//��֤��ɫ�Ƿ��ǵ�ǰ�û���
		if(service.valRoleUserIsExists(roleId, user.getUserId())==0){
			return new Result(1008,"The role does not belong to you! Don't take, please!");
		}
		//��֤�˵��Ƿ��ܹ����з���
		if(service.getMenuIsFicedByMenuId(menuId)==0){//���ܷ�����߲˵�������
			return new Result(1009,"The character cannot have the menu! Please understand!");
		}
		//���ݽ�ɫId�Ͳ˵�Id��֤�Ƿ��Ѿ�����
		if(service.getRoleMenuIsExistsByRoleIdAndMenuId(roleId, menuId)>0){//�Ѿ�����
			return new Result(1009,"��ǰ��ɫ�Ѿ�ӵ�иò˵��������ظ���ӣ�");
		}
		//���
		if(service.addRolemeun(roleId, menuId)>0){
			//��ӳɹ�
			return new Result(200,"��ӳɹ���");
		}
		return new Result(1010,"���ʧ�ܣ�");
	}
	//��ɫ�Ƴ��˵�
	@RequestMapping("removeMenu")
	public @ResponseBody Result removeMenu(String roleId,String menuId){
		if(service.removeRolemeunByRoleIdAndMenuId(roleId, menuId)>0){
			return new Result(200,"�Ƴ��ɹ���");
		}
		return new Result(1011,"�Ƴ�ʧ�ܣ�");
	}
	//��ѯ�û�**********************
	@RequestMapping("userView")//http://localhost:8080/shareboManager/permission/userView.do
	public String userView(ModelMap map,HttpSession session){
		//�õ��û�
		UserInfo user = (UserInfo) session.getAttribute("user");
		if (user == null) {// �û���½��ʱ
			return "login";
		}
		//����userIdѯȫ�����û�
		map.addAttribute("cuser", service.getChildUserInfoByUserId(user.getUserId()));
		//����userId��ѯȫ����ɫ
		map.addAttribute("roles", service.getRolesByUserId(user.getUserId()));
		return "UserManager";
	}
	//�����û�
	@RequestMapping("createUser")
	public @ResponseBody Result creatrUser(String userAccount,String userPassword,HttpSession session){
		//�õ��û�
		UserInfo user = (UserInfo) session.getAttribute("user");
		if (user == null||user.getIsProperty()!=1) {// �û���½��ʱ   ��֤�û��Ƿ񳬼�����Ա����׼����
			return new Result(1012,"���˺Ų��ǳ�������Ա��");
		}
		//��֤�˺���Ч�� ��ĸ����6-20λ
		if(!userAccount.matches("[A-Za-z0-9]{6,20}")){
			return new Result(1011,"�˺Ų��Ϸ���ֻ����6-20��ĸ��������ɣ�");
		}
		//�����ٴμ���
		userPassword=MD5Util.encode(userPassword);
		//��֤�˺��Ƿ��Ѿ�����
		if(service.valUserAccountIsExists(userAccount)>0){//�˺��Ѵ���
			return new Result(2013,"���˺��Ѿ����ڣ��뻻һ�����ԣ�");
		}
		//ƴ���û�
		UserInfo createUser=new UserInfo();
		createUser.setUserId(user.getUserId());
		createUser.setUserAccount(userAccount);
		//����û�
		if(service.createUser(userPassword, createUser)>0){
			return new Result(200,"�����ɹ���");
		}
		return new Result(2012,"����ʧ�ܣ�");
	}
	//ɾ���û�������UserId�޸��û�״̬��
	@RequestMapping("deleteUser")
	public @ResponseBody Result deleteUser(HttpSession session,String userId){
		//��֤����
		if(userId==null||userId.trim().equals("")){
			return new Result(1013,"�������Ϸ���");
		}
		//�õ��û�
     	UserInfo user = (UserInfo) session.getAttribute("user");
		//��֤�û��Ƿ����ڵ�ǰ�û�
     	if(service.valThisUserIsUser(user.getUserId(), userId)==0){
     		return new Result(1014,"Please don't do a good job in blind?");
     	}
     	//ɾ��
     	if(service.updateUserIsDeleteByuserId(userId)>0){
     		//�ɹ�
     		return new Result(200,"ɾ���ɹ���");
     	}
     	return new Result(1015,"ɾ��ʧ�ܣ�");
	}
	//�������루����UserId�޸��û�����123456���μ��ܣ�
	@RequestMapping("resetPwd")
	public @ResponseBody Result resetPwd(String userId,HttpSession session){
		if(userId==null||userId.equals("")){
			return new Result(1016,"�������Ϸ���");
		}
		//�õ��û�
     	UserInfo user = (UserInfo) session.getAttribute("user");
		//��֤�û��Ƿ����ڵ�ǰ�û�
     	if(service.valThisUserIsUser(user.getUserId(), userId)==0){
     		return new Result(1014,"Please don't do a good job in blind?");
     	}
     	//�޸�
     	String pwd=MD5Util.encode(MD5Util.encode("123456"));
     	if(service.resetPwdByuserId(userId, pwd)>0){
     		return new Result(200,"���óɹ���");
     	}
     	return new Result(1015,"����ʧ�ܣ�");
	}
	//�޸��û���ɫ����
	@RequestMapping("updateRole")
	public @ResponseBody Result updateRole(HttpSession session,String userId,String roleId){
		//����ǰ�û��Ľ�ɫ�޸ĳ�ѡ�еĽ�ɫ
		if(userId==null||roleId==null){
			return new Result(1013,"�����쳣��");
		}
		//�õ��û�
     	UserInfo user = (UserInfo) session.getAttribute("user");
		//��֤�û��Ƿ����ڵ�ǰ�û�
     	if(service.valThisUserIsUser(user.getUserId(), userId)==0){
     		return new Result(1014,"Please don't do a good job in blind?");
     	}
		//�޸�
     	if(service.updateUserRole(userId, roleId)>0){
     		return new Result(200,"�޸ĳɹ���");
     	}
     	return new Result(1015,"�޸�ʧ�ܣ�");
	}
}
