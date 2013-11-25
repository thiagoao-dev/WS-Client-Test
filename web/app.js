$(function(){
   $("a.excluir").on("click", function(){
       login = $(this).parent().parent().find(".login").html();
       id    = $(this).data("idusuario");
       if( confirm("Você deseja excluir o [ "+login+" ]?" ) ) {
         $.ajax({
            type : "get",
            url  : "remove",
            data : "idusuario="+id,
            success : function(r){
                console.log(r);
                $("tr#idusuario"+id).remove();
                
            },
            error : function(a,b,c){
              console.log(a);  
              console.log(b);  
              console.log(c);  
            }
         });
       };
       return false;
   }); 
});