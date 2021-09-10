$(document).ready(function(){
  $('.ham').on('click', function(){
    if($(this).hasClass('active')){
      $('.hamnav').stop().fadeOut();
    }else{
      $('.hamnav').stop().fadeIn();
    }
    $('.ham').toggleClass('active');
  });
});