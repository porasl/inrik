<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta  name="_csrf" content="${_csrf.token}"/>
    <meta  name="_csrf_header" content="${_csrf.headerName}"/>
     <meta name="viewport" content="width=device-width, initial-scale=1">
    
   <title>Create an account</title>
   
   <link href="<c:url value='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css'/>" rel="stylesheet" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
   <link href="<c:url value='resources/css/bootstrap.min.css'/>" rel="stylesheet">
   <link href="<c:url value='resources/css/dragdrop.css' />" rel="stylesheet">
   <link href="<c:url value='resources/css/index.css' />" rel="stylesheet">
   <link href="<c:url value='resources/css/dragdrop.css' />" rel="stylesheet">
   <link href="<c:url value='resources/css/style.css' />" rel="stylesheet">
   <link href="<c:url value='resources/css/common.css' />" rel="stylesheet">
   
   <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
   <script src="https://npmcdn.com/tether@1.2.4/dist/js/tether.min.js"></script>
   
   <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
 
   <script src="${contextPath}/resources/js/bootstrap.min.js"></script> 
   <script src="${contextPath}/resources/js/jquery-2.1.1.min.js"></script>
  <!--   <script src="resources/js/jquery-1.12.0.js"></script>
       <script src="resources/js/3.2.1/jquery.min.js"></script>  -->
   
  
  <script> window.Tether = {}; </script>
   <script src="${contextPath}/resources/js/jquery-latest.min.js" type="text/javascript"></script>
   <script src="resources/js/config.js" type="text/javascript" ></script>
   <script src="resources/js/menu/stmenu.js" type="text/javascript"></script>
   
<script type="text/javascript">
	window.google_analytics_uacct = "UA-15926901-3";

function showAlbumSubMenu(){
	document.getElementById("albumsubMenu").style.display='block';
}

function hideAlbumSubMenu(){
	document.getElementById("albumsubMenu").style.display='none';
}

function showImageDropBox(id){
	document.getElementById("imagedropbox").style.display='block';
	selectTemplate(id);
	document.getElementById("colapse").innerHTML="<div onClick='showTemplates()'>Expand</div>";
}

function hideImageDropBox(){
	document.getElementById("imagedropbox").style.display='none';
}

function showTemplates(){
	document.getElementById("uploadImageProgress").style.display='block';
	document.getElementById("templates").style.display='block';
	document.getElementById("colapsableTemplatediv").style.display='block';
	document.getElementById("colapse").innerHTML="<div onClick='hideTemplates()'>Colapse</div>";
}


function hideTemplates(){
	document.getElementById("templates").style.display='none';
	document.getElementById("colapse").innerHTML="<div onClick='showTemplates()'>Expand</div>";
	
}

function selectTemplate(tmpid){
	if(tmpid == 'tmp1' ){
		document.getElementById('tmpbox2').checked=false;
		document.getElementById('tmpbox3').checked=false;
		document.getElementById('tmpbox1').checked=true;
	}else
		if(tmpid == 'tmp2' ){
			document.getElementById('tmpbox1').checked=false;
			document.getElementById('tmpbox3').checked=false;
			document.getElementById('tmpbox2').checked=true;
		}else{
			document.getElementById('tmpbox1').checked=false;
			document.getElementById('tmpbox2').checked=false;
			document.getElementById('tmpbox3').checked=true;
		}
		document.getElementById("selectTempImage").innerHTML= "<font class='blue12'>Template: "+ tmpid +"<br>was selected</font>" ;
		selectedTempId = tmpid;
		document.getElementById("templates").style.display='none';
		document.getElementById("colapse").innerHTML="<div onClick='showTemplates()'>Expand</div>";
		document.getElementById("step2UploadImage").innerHTML="<img src='resources/images/two_green.png' width='40px'/>";
}
</script> 
    
</head>
<body background-color="white" align='center'> 
  <div class="container" align="center">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <font size='3'>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></font>
    </c:if>
  </div>
   <div valign="top" align="center">
    <div class="divTable" valign="top" align="center">
       <div class="divRow" valign="top">
          <div class="divCell" onmouseover="showAlbumSubMenu();" onmouseout="hideAlbumSubMenu();">Photo Albums
         	<table id="albumsubMenu" style="display:none;background-color:white" border='1'>
          	   <td>
          		  <div class='divCellSub' id='createAlbum' onclick="showTemplates();"> Create </div>
          	   </td>
          		<td>
          		  <div class="divCellSub" id='listAlbum'> Show </div> 
         	   </td>
    		 </table>  
          </div>
          <div class="divCell">Video</div>
          <div class="divCell">File Archive</div>
           <div class="divCell">About Us</div>
        </div>     
    </div>
   </div>
  
  
  <table>
<td valign="top" >
<script type="text/javascript"><!--
google_ad_client = "pub-0934845296487679";
/* 160x600, created 8/11/08 */
google_ad_slot = "4310898637";
google_ad_width = 160;
google_ad_height = 600;
//-->
</script>
<script type="text/javascript"
src="http://pagead2.googlesyndication.com/pagead/show_ads.js">
</script>
</td>
<td  valign="top"  id="notDroppable2">
<div  valign="top" id="uploadImageProgress" style="display:none">
  <table >
  <td><div id='step1' align='center'><img src="resources/images/one_green.png" width="40px"></div>
  <div id="selectTempImage"> <font class='blue12'>Select a template</font></div></td>
  <td><div id='progress2'><hr width="150" color="gray"></div></td>
  <td><div id='step2UploadImage'><img src="resources/images/two_gray.png" width="40px"/></div>
  	 <div id="dropImageProcess"> <font class='blue12'>Drag & Drop images</font></div>
  </td>
  <td><div id='progress3'><hr width="150" color="gray"></div></td>
  <td><div id='step3'><img src="resources/images/three_gray.png" width="40px"/><font class='blue12'> <br> Settings</font></div></td>
  <td><div id='progress3'><hr width="150" color="gray"></div></td>
  <td><div id='step3'><img src="resources/images/four_gray.png" width="40px"/> <br><font class='blue12'> Save</font></div></td>
  
  
  </table>

   <div class='colapsableTemplatediv' id="colapsableTemplatediv" style="display:none">
    	<table>
    		<td align="left" width="800px">
    			Available Templates
    		</td>
    		<td id='colapse' align='right' width="200px">
    			<div onClick="hideTemplates()">Colapse</div>
    		</td>
    	</table>
 	</div>
   <div id="templates" style="display:none" width="800px">
  	<table width="800px" valign="top">
  		<td  valign="top" onClick="showImageDropBox(this.id)" id="tmp1">
  			<input  valign="top" type="checkbox" id="tmpbox1"/></br>
  			<img id="tmp1img" src="resources/images/temps/tmp1.png" width="200px" height="100"/>
  		</td>
  		<td valign="top" onClick="showImageDropBox(this.id)" id="tmp2">
  			<input valign="top" type="checkbox" id="tmpbox2"/><br>
  				<img id="tmp2img" src="resources/images/temps/tmp2.png" width="200px" height="100"/>
  		</td>
  			
  		<td onClick="showImageDropBox(this.id)" valign="top" id="tmp3"> 
  			<input valign="top" type="checkbox" id="tmpbox3"/><br>
  			<img id="tmp3img" src="resources/images/temps/tmp1.png" width="200px" height="100"/>
  		</td>
  	</table>
  	</div>
  </div>
  
 <input id="tmpImageFolder" type="hidden" value="" width="800px" /><br>
 <table border="0" width='800px' >
    <td bgcolor="blue">
         <div id="imagedropbox" style="height: 219px; width: 800px;display:none;background-color:#FAFAFA">Drop images here...</div>
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
          <button type="button" class="close" data-dismiss="modal"><font color='white'> <b>&times;</b></button>
          <h4 class="modal-title"><b><font color="white">Insert Album Info </font></b></h4>
        </div>
        <div class="modal-body">
         
   <div>    
   <table>
   <tr>
         <td id='albumNameLabel' class='blue14'  colspan="2">
         Album Name: <input type='text' id='albumName' size="60px"></td>
   	</tr>
   <tr>
         <td class='blue14' colspan="2"><br><input type='checkbox'  id='public' checked> Public Album </td>
   	</tr>
   	<tr>
         <td class='blue14' colspan="2" valign="top">
         <br>Details:<br><textarea cols="50"  rows="5" id="details"></textarea>
          </td>
   	</tr>
   </table>
 
        </div>  
        <div class="modal-footer">
          <button type="button" class="blue14" data-dismiss="modal" onclick="saveAlbum()">Save</button>
          <button type="button" class="blue14" data-dismiss="modal">Close</button>
        </div> 
       
      </div>
      
    </div>
  </div>
  
</div>

 <div id='notDroppable3' width="800px">
 <table width="800px" id="savePanel" style="display:none">
 
  <td width='400px' align="right">
  
   <button  type="button" id="albumInfo" onclick='settingStep()'  width="300px" class="buttonBlue" data-toggle="modal" data-target="#myModal">
   Continue   </button>
  </td>
 </table>
  
  
 <!--   
<table width="800px" border="0">
        <td width="800px">
          <div id="uploadedItems" border="0" class="uploadedStyle"  style="height: 219px; width: 800px;"></div>
         
         </td>
</table>
-->
</div>


<div id="tmpSubFolderName"></div>

 <table width='800px'>
 <td valign='top' width='300px'>
      <font class='blue12' >My Photo Albums  </font>
      <div id="myAlbumLinks"></div>
    </td>
     <td valign='top'>
      <font class='blue12' >My Videos Albums  </font>
    </td>
     <td valign='top'>
      <font class='blue12' >My File Archive  </font>
    </td>
 </table>
</div></td></table>

  
  <!-- The Modal -->
  <div class="modal" id="albumModal">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">Photo Album</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body" id='modal_body'>
          Modal body..
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
        </div>
        
      </div>
    </div>
  </div>
  
  <!-- ------------- End of Modal -->

</body>
<script type="text/javascript">
var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
</script>
<script type="text/javascript">
try {
var pageTracker = _gat._getTracker("UA-15926901-2");
pageTracker._trackPageview();
} catch(err) {}</script>

<script>

window.onload = function() {
	hideImageDropBox();
    var dropbox = document.getElementById("imagedropbox");
    dropbox.addEventListener("dragenter", noop, false);
    dropbox.addEventListener("dragexit", noop, false);
    dropbox.addEventListener("dragover", noop, false);
    dropbox.addEventListener("drop", dropUpload, false);
}

function settingStep(){
    document.getElementById("step3").innerHTML="<img src='resources/images/three_green.png' width='40px'/><br><font class='blue12'> Setting</font>";
}

function noop(event) {
    event.stopPropagation();
    event.preventDefault();
}

function dropUpload(event) {
    noop(event);
    var files = event.dataTransfer.files;

    for (var i = 0; i < files.length; i++) {
        upload(files[i]);
    }
}

  $('#notDroppable').bind('dragover',function(event) {
    event.stopPropagation();    
    event.preventDefault(); 
  });
  $('#notDroppable').bind('drop',function(event) {
	     event.stopPropagation();   
	      event.preventDefault();
  });
  $('#notDroppable1').bind( 'dragover',function(event) {
	   	event.stopPropagation();    
	    event.preventDefault(); 
	});
  $('#notDroppable1').bind( 'drop',function(event) {
	    event.stopPropagation();   
	    event.preventDefault();
  });
  $('#notDroppable2').bind( 'dragover',function(event) {
		event.stopPropagation();    
		event.preventDefault(); 
		});
  $('#notDroppable2').bind( 'drop',function(event) {
		event.stopPropagation();   
		event.preventDefault();
  });
  $('#notDroppable3').bind( 'dragover',function(event) {
		event.stopPropagation();    
		event.preventDefault(); 
		});
  $('#notDroppable3').bind( 'drop',function(event) {
		event.stopPropagation();   
		event.preventDefault();
});
  
function upload(file) {
  //  document.getElementById("status").innerHTML = "Uploading " + file.name;
    var formData = new FormData();
    formData.append("_csrf","${_csrf.token}");
    formData.append("file", file);
    if($('#tmpSubFolderName').val() !=""){
    	formData.append("tmpSubFolderName",$('#tmpSubFolderName').val());
    }
    var xhr = new XMLHttpRequest();
    xhr.withCredentials=false;
    xhr.upload.addEventListener("progress", uploadProgress, false);
    xhr.addEventListener("load", uploadComplete, true);
    xhr.open("POST", "uploadServlet", true); // If async=false, then you'll miss progress bar support.
    xhr.send(formData);
}

function uploadProgress(event) {
    // Note: doesn't work with async=false.
    var progress = Math.round(event.loaded / event.total * 100);
   // document.getElementById("status").innerHTML = "Progress " + progress + "%";
    document.getElementById("savePanel").style.display='block';
    document.getElementById("dropImageProcess").innerHTML="<font class='blue12'>Drag & Drop images</font>";
}

function uploadComplete(event) {
	text = document.getElementById("imagedropbox").innerHTML;
	if(text =="Drop images here..."){
		document.getElementById("imagedropbox").innerHTML ="";
	}
	
	responseText = event.target.responseText.split("\/");
	$('#tmpSubFolderName').val(responseText[0]);
    $('#imagedropbox').append($('<img>', { 
        src : tempImageFolder+event.target.responseText, 
        width : 100, 
        //height : 100, 
        alt : "Test Image", 
        title : "Test Image"
    }));
}
	
function createAlbumRow(itemInfoId, imagePath, selectedTemplate){debugger;
		var albumUrl ="album.jsp?itemInfoId="+itemInfoId +"?${_csrf.parameterName}=${_csrf.token}";
	    album ="<div style='display:none' id='"+itemInfoId  +"' class='content-one'>"+
	    "<img src='resources/images/fb.png' width='30'> &nbsp;" +
	    "<img src='resources/images/twit.png' width='30'> &nbsp; "+
	    "<img src='resources/images/whats.png' width='30'> &nbsp; "+
	    "<img src='resources/images/insta.png' width='30'> &nbsp; "+
	    "<img src='resources/images/mail.png' width='30'></div>";
	   debugger;
	    onclieckShowAlbumStr = "onclick= showAlbumInModule('"+itemInfoId +"','"+ imagePath+"','"+ selectedTemplate +"');";
	    onclieckEditAlbumStr = "onclick= editAlbum('"+itemInfoId +"','"+ imagePath+"','"+ selectedTemplate +"');";
	    onclieckShareAlbumStr = "onclick= shareAlbum('"+itemInfoId +"','"+ imagePath+"','"+ selectedTemplate +"');";
		onclieckDeleteAlbumStr = "onclick= deleteAlbum('"+itemInfoId +"');";
	
		deleteItem = "<td "+ onclieckDeleteAlbumStr +"><img src='resources/images/delete.png' class='myAlbum'  title='Delete Album' /> </td>";
		editItem = "<td "+ onclieckEditAlbumStr +" ><img src='resources/images/edit.png' class='myAlbum'  title='Edit Album'></td>";
		shareItem = "<td "+ onclieckShareAlbumStr +"><img src='resources/images/share2.png' class='myAlbum'  title='Share Album' > </td>";
		showItem = "<td "+ onclieckShowAlbumStr +"><img src='resources/images/show.png' width='30' data-toggle='modal' data-target='#albumModal'  title='Show Album' > </td>";
	  
		hideImageDropBox();
		document.getElementById("uploadImageProgress").style.display='none';
		document.getElementById("savePanel").style.display='none';
		$("#myAlbumLinks").append ("<table>"+ deleteItem + editItem + shareItem + showItem +"<td > <font class='blue12'>"+ decodeURI(name) 
				+"</font></td></table><table><td>"+  album     +"</td></table>");
}  


  function saveAlbum(){
	tmpFolder = $('#tmpSubFolderName').val();
	username = "${pageContext.request.userPrincipal.name}";
	details = $('#details').val();
	albumname= $('#albumName').val();
	publicAlbum= $('#public').is(':checked');debugger;
	var request =	$.ajax({
		  type: "POST",
		  headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json' 
		    },
		  url: serverUrl + "${contextPath}/item?${_csrf.parameterName}=${_csrf.token}",
		 
		  data: { "albumname": encodeURIComponent(albumname), "publicAlbum": encodeURIComponent(publicAlbum), "details": encodeURIComponent(details),
				"selectedTemplate": encodeURIComponent(selectedTempId), "userName": username, "tmpFolder": encodeURIComponent(tmpFolder)
				},
			success: function(data) {
			  name = data[0].name;
			  itemInfoId = data[0].itemInfoId;
			  description = data[0].description;
			  imagePath=data[0].imagePath;
			  selectedTemplate = data[0].selectedTemplate;
			   createAlbumRow(itemInfoId, imagePath, selectedTemplate);
		   },
		  dataType: "json"
	   });	
	}
	
  function showMyAlbums(){
	$.ajax({
		  type: "GET",
		  headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json' 
		    },
		  url: serverUrl + "${contextPath}/items?${_csrf.parameterName}=${_csrf.token}",
		  
		  success: function(data) {debugger;
		     if(data !== undefined){
			   for(i=0; data.length > i;i++){
			   		name = data[i].name;
			   		itemInfoId = data[i].itemInfoId;
			   		description = data[i].description;
			   		imagePath=data[i].imagePath;
			   		selectedTemplate = data[i].selectedTemplate;
			   		createAlbumRow(itemInfoId, imagePath, selectedTemplate);	
			    }
		   }
		  },
		  error: function(xhr, status, error){debugger;
		         var errorMessage = xhr.status + ': ' + xhr.statusText
		         alert('Error - ' + errorMessage);
		     }
	    })
	   }

	
	function showAlbumInModule(itemInfoId,imagePath,selectedTemplate){
		var albumUrl = serverUrl + "${contextPath}/item?id="+itemInfoId+"&${_csrf.parameterName}=${_csrf.token}";
		$.ajax({
			  type: "GET",
			  headers: { 
			        'Accept': 'application/json',
			        'Content-Type': 'application/json' 
			    },
			  url: albumUrl,
			 
			 success: function(data) {debugger;
				 var  name = data[0].name;
				  var deleted = data[0].deleted;
				  var expirationDate = data[0].expirationDate;
				  var notified = data[0].notified;
				  var itemInfoId = data[0].itemInfoId;     
				  var description = data[0].description;
				  var imagePath = data[0].imagePath;
				  var selectedTemplate = data[0].selectedTemplate;
			   },
			  error: function(xhr, status, error){debugger;
		         var errorMessage = xhr.status + ': ' + xhr.statusText
		         alert('Error - ' + errorMessage);
		     }
		   });	
		   alert("name: "+ name + " itemInfoId: "+ itemInfoId +
				   "description: " + description 
				   +" selectedTemplate: "+ selectedTemplate 
				   + "imagePath: "+imagePath);
		   
		   $('#modal_body').text("Name: " +name+ "\n itemInfoId: " +
				   itemInfoId + "\n description: " +description + "\n imagePath: "+ imagePath +
				   "\n selectedTemplate: "+ selectedTemplate);
		return false;
	}
	
	function editAlbum(itemInfoId,imagePath,selectedTemplate){debugger;
		infoArea = document.getElementById(itemInfoId);
		$(infoArea).slideToggle('slow');
		return false;
	}

	function shareAlbum(itemInfoId,imagePath,selectedTemplate){debugger;
		infoArea = document.getElementById(itemInfoId);
		$(infoArea).slideToggle('slow');
		//$(infoArea).display.style='block';
		return false;
	}
	
	
	function deleteAlbum(itemInfoId){
		
	}

	function reset(){
		location.reload();
	}
	
	function getAlbumByTempletOne(imageArray){debugger;
		$('#modal_body').text("5");
	}
	
	$( document ).ready(function() {debugger;
	 showMyAlbums();
	 
	});
	

</script> 
</body>
</html>