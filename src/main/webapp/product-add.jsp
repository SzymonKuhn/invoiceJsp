<%--
  Created by IntelliJ IDEA.
  User: W540
  Date: 2019-09-20
  Time: 17:18
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
    <title>Add product</title>
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

            <form action="${requestScope.productId==null ? '/product-add' : '/product-edit'}" method="post"
                  class="pure-form pure-form-aligned">
                <input type="hidden" name="invoiceId" value="${requestScope.invoiceId}">
                <input type="hidden" name="productId" value="${requestScope.productId}">
                <fieldset>
                    <div class="pure-control-group">
                        <label>Product name</label>
                        <input type="text" name="productName" value="${requestScope.productName}"><br>
                    </div>

                    <div class="pure-control-group">
                        <label>Price</label>
                        <input type="number" step="0.01" min="0.00" name="productPrice"
                               value="${requestScope.productPrice}"><br>
                    </div>

                    <div class="pure-control-group">
                        <label>Tax type</label>
                        <select name="taxType"> //TODO
                            <option ${requestScope.productTaxType=="PRODUCT" ? 'selected' : ''} value="PRODUCT">Product
                            </option>
                            <option ${requestScope.productTaxType=="SERVICES" ? 'selected' : ''} value="SERVICES">
                                Services
                            </option>
                        </select>
                    </div>

                    <div class="pure-control-group">
                        <label>Stock</label>
                        <input type="number" min="0" step="1.0" name="productStock"
                               value="${requestScope.productStock}">
                    </div>

                    <div class="pure-control-group">
                        <label>
                            <input type="submit"
                                   class="pure-button pure-button-primary"
                                   ${requestScope.invoiceReleaseDate!=null ? 'disabled' : ''}value="submit">
                        </label>


                    </div>
                </fieldset>
            </form>
        </div>
    </div>
</div>

</body>
</html>
