<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Create an account</title>

<link
	href="<c:url value='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css'/>"
	rel="stylesheet"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link href="<c:url value='resources/css/bootstrap.min.css'/>"
	rel="stylesheet">
<link href="<c:url value='resources/css/dragdrop.css' />"
	rel="stylesheet">
<link href="<c:url value='resources/css/index.css' />" rel="stylesheet">
<link href="<c:url value='resources/css/dragdrop.css' />"
	rel="stylesheet">
<link href="<c:url value='resources/css/style.css' />" rel="stylesheet">
<link href="<c:url value='resources/css/common.css' />" rel="stylesheet">
<link href="<c:url value='resources/css/jquery-ui.css' />"
	rel="stylesheet">

<script src="${contextPath}/resources/js/jquery-1.12.0.js"></script>
<script src="${contextPath}/resources/js/jquery-3.3.1.slim.min.js"></script>
<script src="${contextPath}/resources/js/popper.min.js"></script>
<script src="${contextPath}/resources/js/tether.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${contextPath}/resources/js/jquery-2.1.1.min.js"></script>
<script src="${contextPath}/resources/js/jquery-ui.js"></script>

<script> window.Tether = {}; </script>
<script src="${contextPath}/resources/js/config.js"
	type="text/javascript"></script>
<script src="${contextPath}/resources/js/menu/stmenu.js"
	type="text/javascript"></script>

<script type="text/javascript">
	window.google_analytics_uacct = "UA-15926901-3";
	var mainImage = "";
	function showAlbumSubMenu() {
		document.getElementById("albumsubMenu").style.display = 'block';
	}

	function hideAlbumSubMenu() {
		document.getElementById("albumsubMenu").style.display = 'none';
	}

	function showImageDropBox() {
		document.getElementById("imagedropbox").style.display = 'block';
		//selectTemplate(1);
	}

	function hideImageDropBox() {
		document.getElementById("imagedropbox").style.display = 'none';
	}

    $(function() {
       $( "#tabs-1" ).tabs();
    });


	
</script>

<style>
#tabs-1 {
	font-size: 14px;
}

.ui-widget-header {
	background: #ffffff;
	border: 0px solid #ffffff;
	color: #FFFFFF;
	font-weight: bold;
}
</style>

</head>
<body background-color="white" align='center'>
	<div class="container" align="center">
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<form id="logoutForm" method="POST" action="${contextPath}/logout">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>

			<font size='3'>Welcome
				${pageContext.request.userPrincipal.name} | <a
				onclick="document.forms['logoutForm'].submit()">Logout</a>
			</font>
		</c:if>
	</div>
	<br>
	<table align="center">
		<td valign="top"><script type="text/javascript">
google_ad_client = "pub-0934845296487679";
/* 160x600, created 8/11/08 */
google_ad_slot = "4310898637";
google_ad_width = 160;
google_ad_height = 600;
</script> <script type="text/javascript"
				src="http://pagead2.googlesyndication.com/pagead/show_ads.js">
</script></td>
		<td valign="top" id="notDroppable2">
				<div>
				  <input id="tmpSubFolderName" type="hidden" value="" width="800px" /><br>
					
						<img src="resources/images/add.png" width='25px' onclick="showImageDropBox(this.id)">
								Create Photo Album</span> <br>
						
						<table><td>
							<div id="imagedropbox"
								style="height: 219px; width: 800px; display: none; background-color: #FAFAFA">Drop
								images here...</div>
								</td>
								</table>
					<!--  Modal -->
					<div class="container">
						<!-- Modal -->
						<div class="modal fade" id="myModal" role="dialog">
							<div class="modal-dialog">

								<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header modalHeaderbackground">
										<button type="button" class="close" data-dismiss="modal">
											<font color='white'> <b>&times;</b>
										</button>
										<h4 class="modal-title">
											<b><font color="white">Insert Album Info </font></b>
										</h4>
									</div>
									<div class="modal-body">
										<div>
											<table>
												<tr>
													<td id='albumNameLabel' class='blue14' colspan="2">
														Album Name: <input type='text' id='albumName' size="60px">
													</td>
												</tr>
												<tr>
													<td class='blue14' colspan="2"><br> <input
														type='checkbox' id='public' checked> Public Album</td>
												</tr>
												<tr>
													<td class='blue14' colspan="2" valign="top"><br>Details:<br>
														<textarea cols="50" rows="5" id="details"></textarea></td>
												</tr>
											</table>

										</div>
										<div class="modal-footer">
											<button type="button" class="blue14" data-dismiss="modal"
												onclick="saveAlbum()">Save</button>
											<button type="button" class="blue14" data-dismiss="modal">Close</button>
										</div>

									</div>

								</div>
							</div>
						</div>

						<div id='notDroppable3' width="800px">
							<table width="800px" id="savePanel" style="display: none">

								<td width='400px' align="right">

									<button type="button" id="albumInfo" onclick='' width="300px"
										class="buttonBlue" data-toggle="modal" data-target="#myModal">Continue</button>
								</td>
							</table>

						</div>

						<div id="tmpSubFolderName"></div>

						<table width='800px'>
							<td valign='top' width='300px'><font class='blue12'><b>

										<div id="numberOfMyPhotoAlbums">Photo Albums</div></font></td>


						</table>

						<div id="myAlbumLinks"></div>
					</div>
					
					<div class="modal" id="albumModal">
						<div class="modal-dialog">
							<div class="modal-content">

							<!-- Modal Header -->
							<div class="modal-header">
								<h4 class="modal-title">Photo Album</h4>
								<button type="button" class="close" data-dismiss="modal">&times;</button>
							</div>

							<!-- Modal body -->
							<div class="modal-body" id='modal_body'>Here we can add images
							</div>

							<!-- Modal footer -->
							<div class="modal-footer">
								<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
							</div>

							</div>
						</div>
					</div>	
	</div>	
				
		</td>
	</table>
	


	<!-- ------------- End of Modal -->

</body>
<script type="text/javascript">
	var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl."
			: "http://www.");
	document
			.write(unescape("%3Cscript src='"
					+ gaJsHost
					+ "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
</script>
<script type="text/javascript">
	try {
		var pageTracker = _gat._getTracker("UA-15926901-2");
		pageTracker._trackPageview();
	} catch (err) {
	}
</script>

<script>

	window.onload = function() {
		hideImageDropBox();
		var dropbox = document.getElementById("imagedropbox");
		dropbox.addEventListener("dragenter", noop, false);
		dropbox.addEventListener("dragexit", noop, false);
		dropbox.addEventListener("dragover", noop, false);
		dropbox.addEventListener("drop", dropUpload, false);
	}

	function settingStep() {
		//document.getElementById("step3").innerHTML = "<img src='resources/images/three_green.png' width='40px'/><br><font class='blue12'> Setting</font>";
	}

	function noop(event) {
		event.stopPropagation();
		event.preventDefault();
	}

	function dropUpload(event) {
		noop(event);
		var files = event.dataTransfer.files;
		mainImage = files[0];
		for (var i = 0; i < files.length; i++) {
			upload(files[i]);
		}
	}

	$('#notDroppable').bind('dragover', function(event) {
		event.stopPropagation();
		event.preventDefault();
	});
	$('#notDroppable').bind('drop', function(event) {
		event.stopPropagation();
		event.preventDefault();
	});
	$('#notDroppable1').bind('dragover', function(event) {
		event.stopPropagation();
		event.preventDefault();
	});
	$('#notDroppable1').bind('drop', function(event) {
		event.stopPropagation();
		event.preventDefault();
	});
	$('#notDroppable2').bind('dragover', function(event) {
		event.stopPropagation();
		event.preventDefault();
	});
	$('#notDroppable2').bind('drop', function(event) {
		event.stopPropagation();
		event.preventDefault();
	});
	$('#notDroppable3').bind('dragover', function(event) {
		event.stopPropagation();
		event.preventDefault();
	});
	$('#notDroppable3').bind('drop', function(event) {
		event.stopPropagation();
		event.preventDefault();
	});

	function upload(file) {
		//  document.getElementById("status").innerHTML = "Uploading " + file.name;
		var formData = new FormData();
		formData.append("_csrf", "${_csrf.token}");
		formData.append("file", file);
		if ($('#tmpSubFolderName').val() != "") {
			debugger;
			formData.append("tmpSubFolderName", $('#tmpSubFolderName').val());
		}
		mainImage = file.name;
		var xhr = new XMLHttpRequest();
		xhr.withCredentials = false;
		xhr.upload.addEventListener("progress", uploadProgress, false);
		xhr.addEventListener("load", uploadComplete, true);
		xhr.open("POST", "uploadServlet", true); // If async=false, then you'll miss progress bar support.
		xhr.send(formData);
	}

	function uploadProgress(event) {
		// Note: doesn't work with async=false.
		var progress = Math.round(event.loaded / event.total * 100);
		// document.getElementById("status").innerHTML = "Progress " + progress + "%";
		document.getElementById("savePanel").style.display = 'block';
		//document.getElementById("dropImageProcess").innerHTML = "<font class='blue12'>Drag & Drop images</font>";
	}

	function uploadComplete(event) {
		text = document.getElementById("imagedropbox").innerHTML;
		if (text =="Drop images here...") {
			document.getElementById("imagedropbox").innerHTML = "";
		}
		responseText = event.target.responseText.split("\/");
		$('#tmpSubFolderName').val(responseText[0]);
		$('#imagedropbox').append($('<img>', {
			src : tempImageFolder + event.target.responseText,
			width : 100,
			//height : 100, 
			alt : "Test Image",
			title : "Test Image"
		}));
	}

	function createAlbumRow(itemInfoId, imagePath, selectedTemplate, thumbnail) {
		var albumUrl = "album.jsp?itemInfoId=" + itemInfoId
				+ "?${_csrf.parameterName}=${_csrf.token}";
		album = "<div style='display:none' id='"+itemInfoId  +"' class='content-one'>"
				+ "<img src='resources/images/fb.png' width='15'> &nbsp;"
				+ "<img src='resources/images/twit.png' width='15'> &nbsp; "
				+ "<img src='resources/images/whats.png' width='15'> &nbsp; "
				+ "<img src='resources/images/insta.png' width='15'> &nbsp; "
				+ "<img src='resources/images/mail.png' width='15'></div>";

		onclieckShowAlbumStr = "onclick= showAlbumInModule('" + itemInfoId
				+ "','" + imagePath + "','" + selectedTemplate + "');";
		onclieckEditAlbumStr = "onclick= editAlbum('" + itemInfoId + "','"
				+ imagePath + "','" + selectedTemplate + "');";
		onclieckShareAlbumStr = "onclick= shareAlbum('" + itemInfoId + "','"
				+ imagePath + "','" + selectedTemplate + "');";
		onclieckDeleteAlbumStr = "onclick= deleteAlbum('" + itemInfoId + "');";

		deleteItem = "<table><td "+ onclieckDeleteAlbumStr +"><img src='resources/images/delete.png' class='myAlbum'  title='Delete Album' /> </td>";
		editItem = "<td "+ onclieckEditAlbumStr +" ><img src='resources/images/edit.png' class='myAlbum'  title='Edit Album'></td>";
		shareItem = "<td "+ onclieckShareAlbumStr +"><img src='resources/images/share2.png' class='myAlbum'  title='Share Album' > </td></table>";
		showItem = "<td colspan='3'  align='center'"+ onclieckShowAlbumStr +
		"><img src='/images/tmpImages/"+ imagePath+ "/"+ thumbnail+"' width='75' height='75'  data-toggle='modal' data-target='#albumModal'  title='Show Album' > </td><tr>";
		nameItem = "<td align='center'> <font color='black'>" + decodeURI(name)
				+ "</font></td><tr>";

		hideImageDropBox();
		document.getElementById("savePanel").style.display = 'none';
		$("#myAlbumLinks").append(
				"<td align='center'><table align='center' width='100px'>"
						+ nameItem + showItem + deleteItem + editItem
						+ shareItem + "<table><td>" + album
						+ "</td></table></td>");
	}

	function saveAlbum() {
		tmpFolder = $('#tmpSubFolderName').val();
		username = "${pageContext.request.userPrincipal.name}";
		details = $('#details').val();
		albumname = $('#albumName').val();
		publicAlbum = $('#public').is(':checked');
		var request = $
				.ajax({
					type : "POST",
					headers : {
						'Accept' : 'application/json',
						'Content-Type' : 'application/json'
					},
					url : serverUrl
							+ "${contextPath}/item?${_csrf.parameterName}=${_csrf.token}",

					data : {
						"action" : "save",
						"albumname" : encodeURIComponent(albumname),
						"publicAlbum" : encodeURIComponent(publicAlbum),
						"details" : encodeURIComponent(details),
						"selectedTemplate" : encodeURIComponent("1"),
						"userName" : username,
						"tmpFolder" : encodeURIComponent(tmpFolder),
						"thumbnail" : encodeURIComponent(mainImage)
					},
					success : function(data) {
						name = data[0].name;
						itemInfoId = data[0].itemInfoId;
						description = data[0].description;
						imagePath = data[0].imagePath;
						thumbnail = data[0].thumbnail;
						selectedTemplate = data[0].selectedTemplate;
						showMyAlbums();
					},
					dataType : "json"
				});

		document.getElementById("tmpSubFolderName").value = "";
		$("#imagedropbox").html("");
	}

	
	function showMyAlbums() {
		$.ajax({
			type : "GET",
			headers : {
						'Accept' : 'application/json',
						'Content-Type' : 'application/json'
					},
			url : serverUrl+ "${contextPath}/items?${_csrf.parameterName}=${_csrf.token}",

			success : function(data) {
						if (data !== undefined) {
							document.getElementById("numberOfMyPhotoAlbums").innerHTML = data.length
									+ " Photo Albums";
							$("#myAlbumLinks").empty();
							$("#myAlbumLinks").append(
									"<table align='center' width='700px'>");
							for (i = 0; data.length > i; i++) {
								name = data[i].name;
								itemInfoId = data[i].itemInfoId;
								description = data[i].description;
								imagePath = data[i].imagePath;
								thumbnail = data[i].thumbnail;
								selectedTemplate = data[i].selectedTemplate;
								$("#myAlbumLinks").append(
										"<td  style='align:center'>");
								createAlbumRow(itemInfoId, imagePath,
										1, thumbnail);
								if ((i + 1) % 8 == 0) {
									$("#myAlbumLinks").append("</td><tr>");
								} else {
									$("#myAlbumLinks").append("</td>");
								}
							}
						}
					},
			error : function(xhr, status, error) {
						var errorMessage = xhr.status + ': ' + xhr.statusText
						alert('Error - ' + errorMessage);
					}
				});
	}

	function showAlbumInModule(itemInfoId, imagePath, selectedTemplate) {
		var albumUrl = serverUrl + "${contextPath}/item?id=" + itemInfoId
				+ "&${_csrf.parameterName}=${_csrf.token}";
		$
				.ajax({
					type : "GET",
					headers : {
						'Accept' : 'application/json',
						'Content-Type' : 'application/json'
					},
					url : albumUrl,

					success : function(data) {
						var contentNames = data[0].contentNames.split(";");
						var images = "<table>";
						for (i = 0; i < contentNames.length - 1; i++) {
							if (i % 4 == 0) {
								images += "<tr>";
							}
							images += "<td><div style='margin: 15px; border: solid 1px;'><input type='checkBox'>"
									+ " <img src='resources/images/fb.png' width='15'> &nbsp;"
									+ "<img src='resources/images/twit.png' width='15'> &nbsp; "
									+ "<img src='resources/images/whats.png' width='15'> &nbsp; "
									+ "<img src='resources/images/insta.png' width='15'> &nbsp; "
									+ "<img src='resources/images/mail.png' width='15'><br><img src='images/tmpImages/"+ data[0].imagePath +"/"+contentNames[i] +"' width=150  height=150></div></td>";
						}
						images += "</table>";

						$('#modal_body').html("");
						$('#modal_body').html(
								"<font size='4'><b>" + decodeURI(data[0].name)
										+ "</b></font>" + "<br> "
										+ decodeURI(data[0].description)
										+ "<br>" + images);
					},

					error : function(xhr, status, error) {
						var errorMessage = xhr.status + ': ' + xhr.statusText
						alert('Error - ' + errorMessage);
					}
				});

		return false;
	}

	function editAlbum(itemInfoId, imagePath, selectedTemplate) {
		infoArea = document.getElementById(itemInfoId);
		$(infoArea).slideToggle('slow');
		return false;
	}

	function shareAlbum(itemInfoId, imagePath, selectedTemplate) {
		infoArea = document.getElementById(itemInfoId);
		$(infoArea).slideToggle('slow');
		//$(infoArea).display.style='block';
		return false;
	}

	function deleteAlbum(itemInfoId) {
		alert("delete is invoked for Album: " + itemInfoId);
		var request = $
				.ajax({
					type : "POST",
					headers : {
						'Accept' : 'application/json',
						'Content-Type' : 'application/json'
					},
					data : {
						"action" : "delete",
						"id" : itemInfoId
					},
					url : serverUrl
							+ "${contextPath}/item?${_csrf.parameterName}=${_csrf.token}",
					success : function(data) {
						alert("Record is deleted");
						showMyAlbums();
					},
					dataType : "json"
				});
		showMyAlbums();
	}

	function createAlbum() {
		alert("Create Album is invoked");
		var request = $
				.ajax({
					type : "POST",
					headers : {
						'Accept' : 'application/json',
						'Content-Type' : 'application/json'
					},
					sync : true,
					data : {
						"action" : "createAlbum"
					},
					url : serverUrl
							+ "${contextPath}/item?${_csrf.parameterName}=${_csrf.token}",
					success : function(data) {
						$("#tmpSubFolderName").val(data[0].albumName);
					},
					dataType : "json"
				});
	}

	function reset() {
		location.reload();
	}

	function getAlbumByTempletOne(imageArray) {
		$('#modal_body').text("5");
	}

	$(document).ready(function() {
		showMyAlbums();

	});
</script>
</body>
</html>