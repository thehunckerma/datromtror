function updateId(){
    var a = "/abdennour/update/" + $('#updateID').val();
    $("#updateForm").attr("action",a);
}
function deleteId(){
    var a = "/abdennour/delete/" + $('#deleteID').val();
    $("#deleteForm").attr("action",a);
}
function showId(){
    var a = "/abdennour/show/" + $('#showID').val();
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
function last(){
    var tab = $("#tab").val();
    switch (tab) {
        case "home":
            homeDiv();
            break;
        case "show":
            showDiv();
            break;
        case "add":
            addDiv();
            break;
        case "update":
            updateDiv();
            break;
        case "delete":
            deleteDiv();
            break;
    }
}