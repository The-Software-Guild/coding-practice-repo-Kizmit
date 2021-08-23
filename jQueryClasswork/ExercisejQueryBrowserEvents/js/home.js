$('#mainInfoDiv').show();
$('#akronInfoDiv').hide();
$('#minneapolisInfoDiv').hide();
$('#louisvilleInfoDiv').hide();
$(document).ready(function () {
});

$('#mainButton').on("click", function(){
    $('#akronInfoDiv').hide();
    $('#minneapolisInfoDiv').hide();
    $('#louisvilleInfoDiv').hide();
    $('#mainInfoDiv').show();
})

$('#akronButton').on("click", function(){
    $('#minneapolisInfoDiv').hide();
    $('#louisvilleInfoDiv').hide();
    $('#mainInfoDiv').hide();
    $('#akronInfoDiv').show();
    $('#akronWeather').hide();
})

$('#minneapolisButton').on("click", function(){
    $('#louisvilleInfoDiv').hide();
    $('#mainInfoDiv').hide();
    $('#akronInfoDiv').hide();
    $('#minneapolisInfoDiv').show();
    $('#minneapolisWeather').hide();
})


$('#louisvilleButton').on("click", function(){
    $('#mainInfoDiv').hide();
    $('#akronInfoDiv').hide();
    $('#minneapolisInfoDiv').hide();
    $('#louisvilleInfoDiv').show();
    $('#louisvilleWeather').hide();
})

$('#louisvilleWeatherButton').on("click", function(){
    $('#louisvilleWeather').toggle();
})

$('#minneapolisWeatherButton').on("click", function(){
    $('#minneapolisWeather').toggle();
})

$('#akronWeatherButton').on("click", function(){
    $('#akronWeather').toggle();
})

$('.table').hover(
    function(){
        $(this).css("background-color", "WhiteSmoke");
    },
    function(){
        $(this).css("background-color", "");
    }
)
