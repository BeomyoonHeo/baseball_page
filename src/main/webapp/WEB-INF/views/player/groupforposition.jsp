<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<h1 style="text-align: center">포지션별 팀의 야구 선수 페이지</h1>
<div class="container mt-3">
    <table class="table table-bordered" style="text-align: center">
        <thead>
            <tr>
               <th>포지션</th>
                <c:forEach var="team" items="${playerlist.teamKey}">
                    <th>${team}</th>
                </c:forEach>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="players" items="${playerlist.playerlist}">
                <tr>
                    <c:forEach var="player" items="${players}">
                        <td>${player.value}</td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<script src="/js/player.js"></script>

<%@ include file="../layout/footer.jsp"%>
