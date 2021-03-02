<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <label>タイトル<br />
        <input type="text" name="title" value="${cloth.title}" />
    </label>
    <br /><br />
<input type="hidden" name="_token" value="${_token}" />
    <form method="POST" action="/first_webapp/OmikujiServlet">
        <button type="submit">作成</button>
    </form>
