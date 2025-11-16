<%-- 
    Document   : notelist.jsp
    Created on : 19 Oct 2025, 20:38:53
    Author     : james
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Note Detail</title>
        <s:head />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    </head>
        
    <body>
        <jsp:include page="header.jsp">
            <jsp:param name="title" value="Note Maintenance"/>
        </jsp:include>
        <div class="container" style="height: 80vh">
                <div class="row">
                    <div class="col-2">
                        <div class="h2 text-center">Navigation</div>
                    </div>
                    <div class="col-10">
                        <s:form cssClass="form-horizontal" action="saveNotemaint" method="post" >
                            <div class="row border border-2 w-100">
                                <div class="d-flex justify-content-end">
                                    <s:submit cssClass="button m-1" theme="simple" value="Save"/>
                                    <s:submit cssClass="button m-1" theme="simple" value="Cancel" action="cancelNotemaint"/>
                                </div>
                            </div>
                            <s:hidden name="note.id"/>
                            <s:textfield name="note.noteName" label="Name" class="form-control" />
                            <s:textarea name="note.noteContent" label="Content" rows="7"/>
                        </s:form>
                    </div>
                </div>
            </div>
            <div class="container-fluid">
                <div class="row" style="height: 10vh;" >
                    <div class="h2 text-center" >Footer</div>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp">
            <jsp:param name="title" value="note"/>
        </jsp:include>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>    
    </body>
</html>

