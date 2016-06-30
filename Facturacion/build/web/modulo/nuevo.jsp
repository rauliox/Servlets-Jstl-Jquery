<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="req" value="${pageContext.request}" />
<c:out value="${req.requestURL}" />    

<!-- linea implementada debido a que se quiere editar un producto en el archivo nuevo.jsp -->
<c:if test="${not empty param.id_producto}" >
    <jsp:include page="/productoServlet?operacion=consultar&id_producto=${param.id_producto}"/>
</c:if>
<script>
    $(document).ready(function(){
        
         $("#btn_add_prod").click(function(e){
                 
                         e.preventDefault();
                             $.ajax({
                                    url: "productoServlet?operacion=insertar",
                                    method: "post",
                                    data: $("#frm_add_prod").serialize(),
                                    success:function(data) {
                                    $("#aviso").html(data);   
                                   // $("#frm_add_prod").hide();
                                    $( "#result" ).load( "modulo/productos.jsp" );
                                   
                                 }
                             });
             });
             
                 $("#btn_edit_prod").click(function(e){
                 alert("ajax."+$("#frm_add_prod").serialize()+".salida");
                         e.preventDefault();
                             $.ajax({
                                    url: "productoServlet?operacion=editar",
                                    method: "post",
                                    data: $("#frm_add_prod").serialize(),
                                    success:function(data2) {
                                    $("#aviso").html(data2);   
                                    $("#frm_add_prod").hide();
                                  $( "#result" ).load( "modulo/productos.jsp" );
                                   
                                 }
                  });
              });
 });
    
</script>

<div id="aviso"></div>
      <form class="form-horizontal" id="frm_add_prod">
     <div class="form-group">
         <label class="control-label col-xs-2">Nombre ${param.id_producto}:</label>
         <div class="col-xs-10">
             <input type="hidden" name="id_producto" class="form-control" value="${productoBean.id_producto}" /> 
        </div>
         <div class="col-xs-10">
             <input type="text" name="nombre" class="form-control" placeholder="" value="${productoBean.nombre}" /> 
        </div>
     </div>
     <div class="form-group">
         <label  class="control-label col-xs-2">Descripcion:</label>
         <div class="col-xs-10">
             <input type="text" name="descripcion" class="form-control" placeholder="Descripcion:" value="${productoBean.descripcion}">
         </div>
     </div>
     <div class="form-group">
         <label class="control-label col-xs-2">Precio:</label>
         <div class="col-xs-10">
             <input type="text" name="precio" class="form-control" placeholder="" value="${productoBean.precio}">
         </div>
     </div>
     <div class="form-group">
         <label class="control-label col-xs-2">Stock:</label>
         <div class="col-xs-10">
             <input type="text" name="stock" class="form-control" placeholder="" value="${productoBean.stock}">
         </div>
     </div>     
     <div class="form-group">
         <div class="col-xs-offset-2 col-xs-10">
             
             <c:if test="${not empty param.id_producto}" >
                <button type="submit" class="btn btn-primary" id="btn_edit_prod">Guardar / Editar</button>
            </c:if>
            <c:if test="${empty param.id_producto}" >
                <button type="submit" class="btn btn-primary" id="btn_add_prod">Guardar </button>
            </c:if>    
             
         </div>
     </div>
</form>
