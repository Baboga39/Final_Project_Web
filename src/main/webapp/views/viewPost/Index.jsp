<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:misc>
  <jsp:attribute name="js">
    <script src="https://cdn.tiny.cloud/1/x0hb0bn8pkdrphzctxpeuv04rxybmsnkj27z60lwkvfkum2s/tinymce/5/tinymce.min.js"
            referrerpolicy="origin"></script>
    <script>
        tinymce.init({
            selector: '#txtContent',
            placeholder: 'Type content here',
            height: 450,
            plugins: 'paste image link autolink lists table media',
            menubar: false,
            toolbar: [
                'undo redo | bold italic underline strikethrough | numlist bullist | alignleft aligncenter alignright | forecolor backcolor | table link image media'
            ],
        });
    </script>
  </jsp:attribute>
    <jsp:body>
        <br><br><br>
        <form action="" method="post">
            <div class="card">
                <h4 class="card-header" >
                    <div class="text-center">ARTICLES POST</div>
                </h4>
                <div class="card-body">
                    <div class="form-group">
                        <label for="txtTitle">Title</label>
                        <input type="text" class="form-control" id="txtTitle" name="Title" autofocus />
                    </div>
                    <div class="form-group">
                        <label for="txtAbstracts">Abstracts</label>
                        <input type="text" class="form-control" id="txtAbstracts" name="Abstracts" autofocus />
                    </div>
                    <div class="form-group">
                        <label for="txtCategories">Categories</label>
                        <input type="text" class="form-control" id="txtCategories" name="Categories" autofocus />
                    </div>
                    <div class="form-group">
                        <label for="txtTags">Tags</label>
                        <input type="text" class="form-control" id="txtTags" name="Tags" autofocus />
                    </div>
                    <div class="form-group">
                        <label for="txtContent">Content</label>
                        <textarea id="txtContent" name="Content"></textarea>
                    </div>
                </div>
                <div class="card-footer">
                    <button type="submit" class="btn btn-primary" >
                        <i class="fa fa-check" aria-hidden="true"></i>
                        Post
                    </button>
                </div>
            </div>
        </form>
    </jsp:body>
</t:misc>