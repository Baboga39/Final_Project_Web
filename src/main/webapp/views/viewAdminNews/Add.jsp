
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:main>
  <jsp:attribute name="js">
    <script src="https://cdn.tiny.cloud/1/1jp8ineln53u6yy75unwd6d2dmxjp1y71wz8b7sfsp6qjo0x/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>
      <script>
        tinymce.init({
          entity_encoding : "raw",
          selector: '#txtContent',
          height: 450,
          plugins: "paste image link autolink lists table media",
          menubar: false,
          toolbar:[
                  "undo redo | bold italic underline strikethrough | numlist bullist | alignleft aligncenter alignright | forecolor backcolor | table link image media"
          ]
        });
      </script>
  </jsp:attribute>

 <jsp:body>
   <div class="content-cate mt-5">
     <form action="" id="#frmAdd" method="post">
       <div class="container">
         <div class="card">
           <div class="card-header d-flex justify-content-md-between">
             <span class="text-title">Bài Viết</span>
           </div>
           <div class="card-body ml-5">

             <div class="form-group">
               <label >Title</label>
               <input type="text" class="form-control w-75" name="title"  placeholder="Nhập vào đây..">
             </div>

             <div class="form-group">
               <label >views</label>
               <input type="text" class="form-control w-75" name="views"  placeholder="Nhập vào đây..">
             </div>
             <div class="form-group">
               <label >Abstract</label>
               <input type="text" class="form-control w-75" name="abstracts"  placeholder="Nhập vào đây..">
             </div>
             <div class="form-group">
               <label >Content</label>
               <textarea class="form-control w-75" name="content" id="txtContent" placeholder="Nhập vào đây.."/>
               </textarea>
             </div>




             <div class="form-group">
               <label >Avatar</label>
               <input type="text" class="form-control w-75" name="Avatar"  placeholder="Nhập vào đây..">
             </div>
             <div class="form-group">
               <label >Image Content</label>
               <input type="text" class="form-control w-75" name="image_content"  placeholder="Nhập vào đây..">
             </div>

           </div>
           <div class="card-footer">
             <div class="row float-right mr-5">
               <a href="${pageContext.request.contextPath}/Admin/Category/Index" class="btn btn-light btn-lg mr-4">Back</a>
               <button type="submit" class="btn btn-success btn-lg">Add Categories</button>
             </div>
           </div>
         </div>
       </div>
     </form>
   </div>
 </jsp:body>

</t:main>
