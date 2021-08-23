$(document).ready(function () {
    
});

$('h1').addClass("text-center");
$('h2').addClass("text-center");

$('.myBannerHeading').removeClass('myBannerHeading').addClass('page-header');

$('#yellowHeading').text("Yellow Team");
$('#yellowTeamList').append('<li> Joseph Banks </li>');
$('#yellowTeamList').append('<li> Simon Jones </li>');

$('#yellowTeamList').css({'background-color': 'yellow'});
$('#redTeamList').css({'background-color': 'red'});
$('#blueTeamList').css({'background-color': 'blue'});
$('#orangeTeamList').css({'background-color': 'orange'});

$('#oops').hide();

$('#footerPlaceholder').remove();

$('.footer').append('<p>Joe McAdams - joedmcadams@gmail.com</p>').css({'font-family' : 'Courier', 'font-size' : '24px'}).addClass("text-center");