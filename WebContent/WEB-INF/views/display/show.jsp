<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${cloth != null}">
                <h2>id : ${cloth.id} の詳細ページ</h2>

                <table>
                    <tbody>
                        <tr>
                            <th>タイトル</th>
                            <td><c:out value="${cloth.title}" /></td>
                        </tr>
                        <tr>
                            <th>帽子</th>
                            <td><c:out value="${cloth.hat}" /></td>
                        </tr>
                        <tr>
                            <th>トップス</th>
                            <td><c:out value="${cloth.tops}" /></td>
                        </tr>
                        <tr>
                            <th>アウター</th>
                            <td><c:out value="${cloth.outerWear}" /></td>
                        </tr>
                        <tr>
                            <th>パンツ</th>
                            <td><c:out value="${cloth.pants}" /></td>
                        </tr>
                        <tr>
                            <th>靴下</th>
                            <td><c:out value="${cloth.socks}" /></td>
                        </tr>
                        <tr>
                            <th>シューズ</th>
                            <td><c:out value="${cloth.shoes}" /></td>
                        </tr>
                        <tr>
                            <th>作成日時</th>
                            <td><fmt:formatDate value="${cloth.created_at}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                        </tr>
                        <tr>
                            <th>更新日時</th>
                            <td><fmt:formatDate value="${cloth.updated_at}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                        </tr>
                    </tbody>
                </table>

                <p><a href="${pageContext.request.contextPath}/index">一覧に戻る</a></p>
                <p><a href="${pageContext.request.contextPath}/edit?id=${cloth.id}">編集する</a></p>
            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>
    </c:param>
</c:import>