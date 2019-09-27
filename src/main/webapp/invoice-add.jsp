<%--
  Created by IntelliJ IDEA.
  User: W540
  Date: 2019-09-19
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" href="//fonts.googleapis.com/css?family=Roboto:300,300italic,700,700italic">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.css">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/milligram/1.3.0/milligram.css">
    <title>Add invoice</title>
</head>
<body>

<div>
    <div class="row">
        <div class="column column-80 column-offset-10">
            <jsp:include page="navigator.jsp"/>
        </div>
    </div>

    <div class="row">
        <div class="column column-80 column-offset-10">
            <form action="${requestScope.invoiceId==null ? '/invoice-add' : '/invoice-edit'}" method="post">
                <input hidden value="${requestScope.invoiceId}" name="invoiceId">
                <fieldset>
                    <div>
                        <label>Client name:</label>
                        <input type="text" name="clientName" value="${requestScope.clientName}"><br>
                    </div>

                    <div>
                        <label>Client address:</label>
                        <input type="text" name="clientAddress" value="${requestScope.clientAddress}"><br>
                    </div>

                    <div>
                        <label>Client NIP:</label>
                        <input type="text" name="clientNip" value="${requestScope.clientNip}" maxlength="10"
                               minlength="10"><br>
                    </div>

                    <div>
                        <label>
                            <input type="submit"
                                   class="pure-button pure-button-primary" ${requestScope.invoiceDateOfRelease!=null ? 'disabled' : ''}
                                   value="Submit">
                        </label>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
</div>
</body>
</html>
