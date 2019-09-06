<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="x" required="true" rtexprvalue="true" %>
<%@ attribute name="y" required="true" rtexprvalue="true" %>
<div>
    <h4>The result of x+y is</h4>
    result = ${x+y}
</div>