$(".svName").click(function () {
    $(this).parent().next(".descr").toggle();
});
$("#lgnBtn").mouseenter(function(e){
    e.stopPropagation();
    $("#lgn").slideDown();
});
$('#lgn').click(function(e){
	e.stopPropagation();
});
$(document, "body").click(function(){
    $("#lgn").slideUp();
});
$("#startSurv").click(function(){
    $("p").slideUp(1000);
    $("#startSurv").slideUp(1000);
    $(".anketa").show(1000);
});
$("#proceedSurv").click(function(){
    if($("input[name=email]").val()!="" && $("input[name=age]").val() !="" && $("input[name=region]").val() !=""){
        $(".anketa").slideUp(1000);
        $("#proceedSurv").slideUp(1000);
        $(".survey").fadeIn(1000);
        $(".survey p").fadeIn(1000);
    }
    else{
        alert("Заповніть усі поля")
    };
});
$("#finishSurv").click(function(){
	alert("Дякуємо за участь в опитуванні!")
})