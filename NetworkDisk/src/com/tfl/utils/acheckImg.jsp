<%@ page language="java" contentType="text/html; charset=UTF-16"
    pageEncoding="UTF-16"%>

<!-- 验证码 -->
	<label class="col-sm-4" for="Inputpwd">验证码：</label>
		<div class="col-sm-8" style="margin-left:-22px">
			<input type='text' class="form-control form-group col-sm-3" style="width:70px;margin-right:5px;"
			 name='checkCode' />
			<img src='checkImage' id='checkImg' style="width:70px;height:30px;"/>
				<script>
					var r=Math.random();                                                        
					this.src='checkImage?'+r;                                                   
					};                                                                          
  				</script>
 			</div>
