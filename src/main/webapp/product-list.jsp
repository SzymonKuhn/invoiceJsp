<%--
  Created by IntelliJ IDEA.
  User: W540
  Date: 2019-09-20
  Time: 16:38
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
    <title>Product list</title>
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
                    <th>Name</th>
                    <th>Price</th>
                    <th>Tax</th>
                    <th>Tax type</th>
                    <th>Stock</th>
                    <th>Invoice id</th>
                    <th>Edit product</th>
                    <th>Delete product</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="product" items="${requestScope.productList}">
                    <tr>
                        <td>${product.getId()}</td>
                        <td>${product.getName()}</td>
                        <td>${product.getPrice()}</td>
                        <td>${product.getTax()}</td>
                        <td>${product.getTaxType()}</td>
                        <td>${product.getStock()}</td>
                        <td>${product.getInvoice().getId()}</td>
                        <td><a href="/product-edit?productId=${product.getId()}" class="button"
                            ${product.getInvoice().getDateOfRelease()!=null ? 'disabled' : ''}>Edit</a>
                        </td>
                        <td><a href="/product-delete?productId=${product.getId()}" class="button"
                            ${product.getInvoice().getDateOfRelease()!=null ? 'disabled' : ''}>Delete</a>
                        </td>
                    </tr>
                </c:forEach>


                </tbody>
            </table>
        </div>
    </div>

    <div class="row">
        <div class="column column-80 column-offset-10">
            <a href="/product-add?invoiceId=${requestScope.invoice.getId()}" class="button"
               <c:if test="${invoice.getDateOfRelease()!=null}">disabled</c:if>
               <c:if test="${invoice==null}">disabled</c:if> >Add product</a></td>
        </div>
    </div>
</div>

</body>
</html>
