$(document).ready(function() {
    var NavY = $('.navSpace').offset().top;

    var stickyNav = function(){
        var Scrolly = $(window).scrollTop();

        if (Scrolly > NavY){
            $('.navSpace').addClass('sticky');
        } else{
            $('.navSpace').removeClass('sticky');
        }
    };

    stickyNav();

    $(window).scroll(function (){
        stickyNav();
    });
});