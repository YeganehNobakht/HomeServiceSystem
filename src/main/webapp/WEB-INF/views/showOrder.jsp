<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>show order</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>


<form action="/sub/subCategory" method="get" id="serviceForm">
    <select name="service" onchange="submitForm()">
        <option value="NONE" label="${selectedService}">${selectedService}</option>
        <c:forEach items="${serviceList}" var="list">
            <c:if test="${list.name ne selectedService}">
                <option value="${list.name}">${list.name}</option>
            </c:if>

        </c:forEach>
    </select>
</form>
<form:form method="post" modelAttribute="newOrder" action="/order/add">


    <form:select path="subCategory">
        <c:forEach items="${subServiceList}" var="list1">
            <option value="${list1}">${list1}</option>

        </c:forEach>
    </form:select>


    <form:input path="jobDescription" placeHolder="Job Description"/>
    <form:input type="date" placeHolder="Work Date" path="workDate"/>
    <form:input path="city" placeHolder="city name"/>
    <form:input path="street" placeHolder="street name"/>
    <form:input path="alley" placeHolder="alley name"/>
    <form:hidden path="serviceCategory"  value="${selectedService}"/>

    <button type="submit" value="Add">Add</button>
</form:form>

<script>
    function submitForm()
    {
        document.getElementById("serviceForm").submit();
    }
</script>


<%--<form:form modelAttribute="newOrder" method="post" action="/order/add">--%>


<%--    <form:select path="subCategory.name">--%>
<%--        <form:option value="NONE" label="Select"/>--%>
<%--        <form:options items="${subServiceList}"/>--%>
<%--    </form:select>--%>


<%--    <form:input path="jobDescription" placeHolder="Job Description"/>--%>
<%--    <form:input  type="date" path="workDate" placeHolder="Work Date"   name="workDate"/>--%>
<%--    <form:input path="addressDto.city" placeHolder="city name"/>--%>
<%--    <form:input path="addressDto.street" placeHolder="street name"/>--%>
<%--    <form:input path="addressDto.alley" placeHolder="alley name"/>--%>
<%--    <form:input path="serviceCategory.name" name="service" type="hidden" value="${selectedService}"/>--%>

<%--    <form:button type="submit" value="Add">Add</form:button>--%>
<%--</form:form>--%>

<%--<script>--%>
<%--    function submitForm() {--%>
<%--        console.log("success")--%>
<%--        document.getElementById("serviceForm").submit();--%>
<%--        console.log("error")--%>

<%--    }--%>
<%--</script>--%>


<%--<form:form cssClass="m-3 p-3 text-center" action="/order/add" method="post">--%>
<%--    <tr>--%>
<%--        <td>--%>
<%--            Service--%>
<%--        </td>--%>
<%--        <td>--%>
<%--            <select name="service" id="Service" size="1" onchange="makeSubmenu(this.value)">--%>
<%--                <option value="NONE" label="...Select..."></option>--%>

<%--                <c:forEach items="${services}" var="servicesValue">--%>
<%--                    <option value="${servicesValue.name}">--%>
<%--                            ${servicesValue.name}--%>
<%--                    </option>--%>
<%--                </c:forEach>--%>
<%--            </select>--%>
<%--        </td>--%>
<%--    </tr>--%>

<%--    <tr>--%>
<%--        <td>--%>
<%--            <select id="subService" name="subService" size="2" >--%>
<%--                <option value=""> Select a Subservice</option>--%>
<%--                <option></option>--%>
<%--            </select>--%>
<%--        </td>--%>
<%--    </tr>--%>

<%--</form:form>--%>

<%--<script>--%>
<%--    // var citiesByState = {--%>
<%--    //     Tehran: ["Firozkooh","Damavand","Tehran","Varamin"],--%>
<%--    //     Isfahan: ["Najafabad","Kashan","Shahreza","Isfahan"],--%>
<%--    //     Alborz: ["Fardis","Mehrshahr","Nazarabad","Hashtgerd"]--%>
<%--    // }--%>
<%--    function makeSubmenu( value) {--%>
<%--        console.log("in method")--%>
<%--        const res = JSON.parse(${services});--%>
<%--        console.log(res)--%>
<%--        var results ={};--%>
<%--        for (var i = 0; i < objectList.length; i++) {--%>
<%--            results.push(objectList[i].name = objectList[i].subCategoryList);--%>
<%--        }--%>
<%--        console.log(results)--%>

<%--        if (value.length === 0) document.getElementById("subService").innerHTML = "<option></option>";--%>
<%--        else {--%>
<%--            var serviceOptions = "";--%>
<%--            for (var serviceId in objectList[value]) {--%>
<%--                serviceOptions += "<option>" + results[value][serviceId] + "</option>";--%>
<%--            }--%>
<%--            document.getElementById("subService").innerHTML = serviceOptions;--%>
<%--        }--%>
<%--    }--%>
<%--</script>--%>
</body>
</html>
