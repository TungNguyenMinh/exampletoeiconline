<%@ taglib prefix="dec" uri="http://www.opensymphony.com/sitemesh/decorator" %>

<html>
<head>
    <title><dec:title default="Admin Page" /></title>
    <dec:head/>
</head>
<body>
    <%@ include file="/common/admin/header.jsp" %>
    <%@ include file="/common/admin/menu.jsp" %>
<dec:body/>
    <%@ include file="/common/admin/footer.jsp" %>
</body>
</html>