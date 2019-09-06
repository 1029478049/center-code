<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%--<fmt:setTimeZone value="Asia/Shanghai"/>--%><%-- 设置jsp时区 --%>
<c:set value="${sessionScope['org.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEY'].primaryPrincipal}" var="LOGIN_USER"  />
<%--<c:set value="${pageContext.request.contextPath}" var="ctx"/>--%>

