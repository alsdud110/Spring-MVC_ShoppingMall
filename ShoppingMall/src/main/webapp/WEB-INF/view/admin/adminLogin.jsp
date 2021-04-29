<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자 로그인페이지</title>
<jsp:include page="../header.jsp"></jsp:include>
<script>
    $(document).ready(function(){
        $("#btnLogin").click(function(){
            // 태크.val() : 태그에 입력된 값
            // 태크.val("값") : 태그의 값을 변경 
            var admin_id = $("#admin_id").val();
            var admin_pw = $("#admin_pw").val();
            if(admin_id == ""){
                alert("아이디를 입력하세요.");
                $("#admin_id").focus(); // 입력포커스 이동
                return; // 함수 종료
            }
            if(admin_pw == ""){
                alert("비밀번호를 입력하세요.");
                $("#admin_pw").focus();
                return;
            }
            // 폼 내부의 데이터를 전송할 주소
            document.form1.action="${path}/admin/loginCheck.do"
            // 제출
            document.form1.submit();
        });
    });
</script>
</head>
<body>

<h2>관리자 로그인</h2>
    <form name="form1" method="post">
        <table border="1" width="400px">
            <tr>
                <td>아이디</td>
                <td><input name="admin_id" id="admin_id"></td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input type="password" name="admin_pw" id="admin_pw"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button type="button" id="btnLogin">로그인</button>
                <c:if test="${msg == 'failure'}">
                    <div style="color: red">
                        아이디 또는 비밀번호가 일치하지 않습니다.
                    </div>
                </c:if>
                <c:if test="${msg == 'logout'}">
                    <div style="color: red">
                        로그아웃되었습니다.
                    </div>
                </c:if>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
