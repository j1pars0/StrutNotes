
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Categories List</title>
        <s:head />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    </head>

    <body>
        <jsp:include page="header.jsp">
            <jsp:param name="title" value="Categories List"/>
        </jsp:include>
        <div class="container" style="height: 80vh" >
            <div class="row">
                <div class="col-2">
                    <s:url action="index" var="noteurl"/>
                    <a href="<s:property value="#noteurl" />">Notes</a>                </div>
                <div class="col-10">
                    <div class="row border border-2 w-100">
                        <div class="d-flex justify-content-end">
                            <s:url action="inputCategorymaint" var="newurl">
                                <s:param name="category.id" value="0"/>
                            </s:url>                           
                            <a class="button m-1" href="<s:property value="#newurl"/>" />New</a>
                        </div>
                    </div>
                    
                    <table class="table w-100">
                        <tr>
                            <td style="width: 65%">Name</td>
                            <td style="width: 15%">Created</td>
                            <td style="width: 15%">Modified</td>
                            <td style="width: 5%"></td>
                        </tr>
                        <s:iterator value="categories" var="category" >
                        <tr>
                            <s:url action="inputCategorymaint" var="mainturl">
                                <s:param name="category.id" value="%{#category.id}"/>
                            </s:url>
                            <td><a href="<s:property value="#mainturl"/>">${category.categoryName}</a></td>
                            <td>${category.getCreateDateFormatted()}</td>
                            <td>${category.getModifyDateFormatted()}</td>
                            <s:url action="deleteCategorymaint" var="deleteurl">
                                <s:param name="category.id" value="%{#category.id}"/>
                            </s:url>
                            <td><a href="<s:property value="#deleteurl" />" onclick="return confirmDelete();"><image src="images/trash.svg" /></a></td>
                        </<tr>
                        </s:iterator>
                    </table>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp">
            <jsp:param name="title" value="categorylist"/>
        </jsp:include>
        <script type="text/javascript">
            function confirmDelete() { 
                return window.confirm("Are you sure you want to delete the record?");
            }
        </script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>    
                        
    </body>
</html>
