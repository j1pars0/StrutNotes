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
        <title>JSP Page</title>
    </head>

    <body>
        <h1>Notes List</h1>
        <table>
            <s:iterator value="notes" var="note" >
            <tr>
                <td><s:property value="note.id" /></td>
                <td><s:property value="note.noteName" /></td>
                <td><s:property value="note.noteContent" /></td>
            </<tr>
            </s:iterator>
        </table>
    </body>
</html>
