       
       
 // tener en cuenta la utilizacion de (document).ready , el mal uso puede ocacionar 
 // problemas con la ejecución de las funciones internas
$(document).ready(function(){
             $("#btn-login").click(function(e){
                         e.preventDefault();
                         var datos = $(loginform).serialize();
                         $.ajax({
                                method: "POST",
                                url: "login?accion=verificar",
                                data: datos  ,
                                success:(function( msg ) {
                                        if(msg === "ok"){
                                          window.location.href = "login?accion=redirectHome";  
                                        }
                                        else{
                                          $("#msjsalida").html("."+msg+"."); 
                                        }

                                })
                
                            });
                     });       
        
        // Load de las paginas del menu
                      
                 $("#btnproductos").click(function(e){
                            e.preventDefault();
                           $( "#result" ).load( "modulo/productos.jsp" );
                     }); 
                    $("#btn_aproducto").click(function(e){
                             e.preventDefault();
                            $( "#result" ).load( "modulo/nuevo.jsp" );
                       }); 
                    $("#btn_reporte").click(function(e){
                             e.preventDefault();
                            $( "#result" ).load( "modulo/reporte.jsp" );
                    }); 
                  
        // Fin de las paginas del menu
        
  
    
});


//Funciones que se ejecutan de forma independiente con algún evento.    

  /* - INICIO DIALOG CON JQUERY UI (ALGUNOS PROBLEMAS DE ESTABILIDAD)
       // var $dialog;
       //var $html1;
      / $(function() {
       $html1=$( "<div></div>" );
       $dialog= $html1.dialog({
       autoOpen: false,
       title: 'Producto'
                    });
       });               
      */ 

 function editar_prod(var2){
           
             $.ajax({
                      url: "modulo/nuevo.jsp",
                      method: "post",
                      data: { id_producto : var2},
                      success:function(salida) {
                         alert(salida);
                       $("#todo").html(salida);// SIN DIALOG
                      // $( "#result" ).load( "modulo/productos.jsp" );                     //
                        // DIALOG CON JQUERY UI  $html1.html(salida);
                       // DIALOG CON JQUERY UI   $dialog.dialog( "option", "width", $('table').width() );
                       // DIALOG CON JQUERY UI  $dialog.dialog('open');
                    
                       }
 });
       
       return false;
}
  
    // Eliminar simple Javascript + Jquery
function eliminar_prod(valor){
        $.ajax({
           url:"productoServlet?operacion=eliminar",
           method:"post",
           data:{ id_producto: valor},
           success:function(result){
           alert("REGRESO"+result);
         $( "#result" ).load( "modulo/productos.jsp" );
           // tambien funciona  $("#prod_"+valor).remove();
           }
         });
  return false;
}




