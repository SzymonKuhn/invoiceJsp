<%--
  Created by IntelliJ IDEA.
  User: W540
  Date: 2019-09-19
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.time.format.DateTimeFormatter" %>

<%@ page isELIgnored="false" %>

<html>
<head>
    <link rel="stylesheet" href="//fonts.googleapis.com/css?family=Roboto:300,300italic,700,700italic">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.css">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/milligram/1.3.0/milligram.css">
    <title>Invoice List</title>
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
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Creation date</th>
                    <th>Client name</th>
                    <th>Client address</th>
                    <th>Client NIP</th>
                    <th>Is paid</th>
                    <th>Bill Value</th>
                    <th>Number of products</th>
                    <th>Release date</th>
                    <th>Pay date</th>
                    <%--<th>Products</th>--%>
                    <%--<th>Action</th>--%>
                    <%--<th>Edit invoice</th>--%>
                    <%--<th>Delete invoice</th>--%>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="invoice" items="${requestScope.invoiceList}">
                    <tr>
                        <td>${invoice.getId()}</td>
                        <td>${invoice.getDateOfCreation().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))}</td>
                        <td>${invoice.getClientName()}</td>
                        <td>${invoice.getClientAddress()}</td>
                        <td>${invoice.getClientNip()}</td>
                        <td>${invoice.isIfPaid()}</td>
                        <td>${invoice.getBillValue()}</td>
                        <td>${invoice.getNumberOfProducts()}</td>
                        <td>${invoice.getDateOfRelease().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))}</td>
                        <td>${invoice.getDateOfPayment().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))}</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><a href="/invoice-edit?invoiceId=${invoice.getId()}" class="button"
                            ${invoice.getDateOfRelease()!=null ? 'disabled' : ''}>Edit invoice</a></td>

                        <td><a href="/invoice-delete?invoiceId=${invoice.getId()}" class="button"
                               class="pure-button pure-button-primary">Delete invoice</a></td>

                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>

                        <td><a href="/product-list?invoiceId=${invoice.getId()}" class="button">Products</a></td>


                        <td><a href="/invoice-release?invoiceId=${invoice.getId()}"
                               class="button" ${invoice.getDateOfRelease()!=null ? 'disabled' : ''}>Release</a></td>


                        <td><a href="/invoice-pay?invoiceId=${invoice.getId()}"
                               class="button" ${invoice.getDateOfPayment()!=null ? 'disabled' : ''}>Pay</a></td>


                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
