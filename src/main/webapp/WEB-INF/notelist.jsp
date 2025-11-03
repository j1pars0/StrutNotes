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
        <s:head />
    </head>

    <body>
        <h1>Notes List</h1>
        <table>
            <s:iterator value="notes" var="note" >
            <tr>
                <s:url action="inputNotemaint" var="mainturl">
                    <s:param name="note.id" value="%{#note.id}"/>
                </s:url>
                <td>${note.id}</td>
                <td>${note.noteName}</td>
                <td>${note.noteContent}</td>
                <td><a href="<s:property value="#mainturl"/>">Modify</a></td>
            </<tr>
            </s:iterator>
            <tr>
                <s:url action="inputNotemaint" var="newurl">
                    <s:param name="note.id" value="0"/>
                </s:url>
                <td><a href="<s:property value="#newurl"/>" />New</a></td>
            </tr>    
        </table>
    </body>
</html>
