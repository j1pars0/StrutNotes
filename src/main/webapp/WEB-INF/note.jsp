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
        <title>Note Detail</title>
        <s:head />
    </head>

    <body>
        <h1>Note Maintenance</h1>
        <s:form action="saveNotemaint" method="post" >
            <s:hidden name="note.id"/>
            <s:textfield name="note.noteName" label="Name" />
            <s:textarea name="note.noteContent" label="Content" />
            <s:submit value="Save" />
        </s:form>
    </body>
</html>

