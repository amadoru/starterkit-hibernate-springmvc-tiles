<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<li>
    <a class="first" href="<c:url value='/welcome.do' />">
        <span class="square"></span>
        User Welcome Page
    </a>
</li>
<li>
    <a href="<c:url value='/admin/welcome.do' />">
        <span class="square"></span>
        Admin Welcome Page
    </a>
</li>
<li>
    <a class="last" href="<c:url value='/j_spring_security_logout' />">
        <span class="square"></span>
        Logout
    </a>
</li>