<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<label for="email-code">�����ڵ�</label> <span class="certificationTime" style="margin-left: 10px; color: red;">03:00</span>
<div id="email-confirm-group" class="address-group">
   <input type="text" id="email-code">
   <button type="button" class="btn" id="email-confirm-btn" onclick="confirm()">Ȯ��</button>
</div>
<script>
function confirm() {
	  console.log("${requestScope.code}");
		let email_code = $('#email-code').val();
	    if(email_code=="${requestScope.code}"){
	      $('#email-confirm').val('true');
	      $('#email-check-result').text('��������');
	      $('#email-check-result').css('color', 'green');
	      $('#email-check').css('display', 'none');
	    }else{
	      $('#email-confirm').val('false');
	      $('#email-check').text('�����ڵ尡 ��ġ���� �ʽ��ϴ�');
	      $('#email-check').css('display', 'block');
	      $('#email-check').css('color', 'red');
	    }
	}
</script>