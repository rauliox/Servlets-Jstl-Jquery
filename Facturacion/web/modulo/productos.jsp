<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

</head>
<c:set var="req" value="${pageContext.request}" />
<c:out value="${req.requestURL}" />
<h1>Lista de Productos</h1>
<jsp:include page="/productoServlet?operacion=listar" />

   

     <table class="table table-hover">
         <thead>
             <tr>
                 <th>#</th>
                 <th>Nombre</th>
                 <th>Producto</th>
                 <th>Descripcion</th>
                 <th>Stock</th>
                 <th>Operaciones</th>
             </tr>
         </thead>
         <c:set var="i" value="0" />  
           <c:forEach items="${listaproductos}" var="item"> 
               
               <tr id="prod_${item.id_producto}">
                 <td >${i=i+1}</td>
                 <td>${item.nombre}</td>
                 <td>${item.descripcion}</td>
                 <td>${item.precio}</td>
                 <td>${item.stock}</td>
                 <td><a href="#" onclick="return eliminar_prod('${item.id_producto}')" >Eliminar</a> | <a href="#" onclick="return editar_prod('${item.id_producto}')" >Editar</a></td>
               </tr>
             </c:forEach> 
        </table>
