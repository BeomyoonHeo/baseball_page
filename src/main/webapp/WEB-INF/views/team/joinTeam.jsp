<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<h1 style="text-align: center">팀 등록 페이지 입니다.</h1>
<div class="container mt-3">

	<div class="input-group mb-1" style="width: 500px; left: 30%">
	<p>야구장 이름 :</p> 
    <select name="dog-names" id="stadiumlist">
    <c:forEach var="stadium" items="${Stadiumlist}">
     <option value="${stadium.id}">${stadium.name}</option>
    </c:forEach>
    </select>
	<p>팀이름:</p>
  <input id="name" type="text" class="form-control" placeholder="이름입력">
  
  <button id="btnConfirm" class="btn btn-success" type="button">등록</button>
</div>
</div>

<script src="/js/team.js"></script>


<%@ include file="../layout/footer.jsp"%>