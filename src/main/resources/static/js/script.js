function updateId(){
    var a = "/abdennour/update/" + $('#updateID').val();
    console.log(a);
    $("#updateForm").attr("action",a);
}
function deleteId(){
    var a = "/abdennour/delete/" + $('#deleteID').val();
    console.log(a);
    $("#deleteForm").attr("action",a);
}
function showId(){
    var a = "/abdennour/show/" + $('#showID').val();
    console.log(a);
    $("#showForm").attr("action",a);
}
function homeDiv(){
    $("#home").show();
    $("#show").hide();
    $("#add").hide();
    $("#update").hide();
    $("#delete").hide();
    $("#homeNav").addClass( "active" );
    $("#showNav").removeClass("active");
    $("#addNav").removeClass("active");
    $("#updateNav").removeClass("active");
    $("#deleteNav").removeClass("active");
}
function showDiv(){
    var a = "/abdennour/update/" + $('#updateID').val();
    console.log(a);
    $("#home").hide();
    $("#show").show();
    $("#add").hide();
    $("#update").hide();
    $("#delete").hide();
    $("#homeNav").removeClass( "active" );
    $("#showNav").addClass("active");
    $("#addNav").removeClass("active");
    $("#updateNav").removeClass("active");
    $("#deleteNav").removeClass("active");
}
function addDiv(){
    $("#home").hide();
    $("#show").hide();
    $("#add").show();
    $("#update").hide();
    $("#delete").hide();
    $("#homeNav").removeClass( "active" );
    $("#showNav").removeClass("active");
    $("#addNav").addClass("active");
    $("#updateNav").removeClass("active");
    $("#deleteNav").removeClass("active");
}
function updateDiv(){
    $("#home").hide();
    $("#show").hide();
    $("#add").hide();
    $("#update").show();
    $("#delete").hide();
    $("#homeNav").removeClass( "active" );
    $("#showNav").removeClass("active");
    $("#addNav").removeClass("active");
    $("#updateNav").addClass("active");
    $("#deleteNav").removeClass("active");
}
function deleteDiv(){
    $("#home").hide();
    $("#show").hide();
    $("#add").hide();
    $("#update").hide();
    $("#delete").show();
    $("#homeNav").removeClass( "active" );
    $("#showNav").removeClass("active");
    $("#addNav").removeClass("active");
    $("#updateNav").removeClass("active");
    $("#deleteNav").addClass("active");
}