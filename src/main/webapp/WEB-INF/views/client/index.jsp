<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">
    <meta property="og:type" content="website">
    <meta property="og:title" content="인천검단 레미안">
    <title>인천검단 레미안</title>
    <!-- css -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/client/normalize.css?v=<%=System.currentTimeMillis()%>">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/client/slick.css?v=<%=System.currentTimeMillis()%>">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/client/swiper.min.css?v=<%=System.currentTimeMillis()%>">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/client/bootstrap.min.css?v=<%=System.currentTimeMillis()%>">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/client/cal-style.css?v=<%=System.currentTimeMillis()%>">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/client/common.css?v=<%=System.currentTimeMillis()%>">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/client/top.css?v=<%=System.currentTimeMillis()%>">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/js/sweetalert.min.css?v=<%=System.currentTimeMillis()%>">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js?v=<%=System.currentTimeMillis()%>"></script>
    <script src="${pageContext.request.contextPath}/static/css/js/bootstrap.min.js?v=<%=System.currentTimeMillis()%>"></script>
</head>
<body>
<!-- wrap -->
<div id="mask"></div>
<div id="wrap">
    <!-- header -->
    <%@include file="/WEB-INF/views/client/fragments/header.jsp" %>
    <!--// header -->
    <!-- container -->
    <div id="container">

        <!-- 페이지 시작 -->
        <div id="index">
            <!-- 메인 화면 시작  -->
            <%@include file="/WEB-INF/views/client/fragments/main.jsp" %>
            <!--타입정보 시작 -->
            <section id="px4" class="sect04 px-sect last-sect">
                <div class="w-base">
                    <div class="tit-area  animated fadeInUp m_center">
                        <h3>편안하고 실용적인 <br class="m_br">합리적 공간배치<br class="m_br"><a href="#">more</a></h3>
                        <p class="animated fadeInUp m_center">더 나은 삶, 나은 내일<br>가족의 행복한 이야기로 가득 채워집니다</p>
                    </div>


                    <div class="contents-4-box row">
                        <div>
                            <ul class="nav nav-tabs box-nav m_flex_center">
                                <!-- 타입 출력 -->
                                <c:forEach var="config" items="${configs}" varStatus="loop">
                                    <c:if test="${config.ause eq 'O' }">
                                        <li>
                                            <button type="button" class="tab_showroom ${loop.first ? 'active' : '' }" data-num="${loop.index+1}">${config.atype}</button>
                                        </li>
                                    </c:if>
                                </c:forEach>
                                <!-- 타입 출력 끝-->
                            </ul>
                        </div>
                        <div class="col-sm-12 col-xs-12">
                            <div class="iso-box">
                                <c:forEach var="config" items="${configs}" varStatus="loop">
                                    <c:if test="${config.ause eq 'O'}">
                                        <div class="showroom" id="showroom_${loop.index +1}">
                                            <span><img src="${config.aimgUrl }" class="img-responsive center-block" alt=""></span>
                                            <div class="area-info col-sm-1">
                                                <h4>타입명</h4>
                                                <ul>
                                                    <li>
                                                        <h5>주거전용</h5>
                                                        <p>${config.aprivate}㎡</p>
                                                    </li>
                                                    <li>
                                                        <h5>주거공용</h5>
                                                        <p>${config.apublic}㎡</p>
                                                    </li>
                                                    <li>
                                                        <h5>기타공용</h5>
                                                        <p>${config.aetcpublic}㎡</p>
                                                    </li>
                                                    <li>
                                                        <h5>계약면적</h5>
                                                        <p>${config.acontractSize}㎡</p>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                    </c:if>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- 타입정보 끝  -->
        </div>

        <!-- //페이지 끝 -->

    </div>
    <!-- //container -->

    <!-- footer -->
    <%@include file="/WEB-INF/views/client/fragments/footer.jsp" %>
    <!-- // footer -->

</div>
<%--<c:if test="${not empty msg}">--%>
<%--    <script>alert("${msg}")</script>--%>
<%--</c:if>--%>
<!-- //wrap -->
<script src="${pageContext.request.contextPath}/static/css/js/slick.min.js?v=<%=System.currentTimeMillis()%>"></script>
<script src="${pageContext.request.contextPath}/static/css/js/common.js?v=<%=System.currentTimeMillis()%>"></script>
<script src="${pageContext.request.contextPath}/static/css/js/swiper.min.js?v=<%=System.currentTimeMillis()%>"></script>
<script src="${pageContext.request.contextPath}/static/css/js/layout.js?v=<%=System.currentTimeMillis()%>"></script>
<script>
    $(".tab_showroom").on("click", function () {
        var num = $(this).data("num");
        $(".tab_showroom").removeClass("active");
        $(this).addClass("active");
        $(".showroom").hide();
        $("#showroom_" + num).show();
        $(".showroom_slide").hide();
        $("#showroom_slide_" + num).show();

        if( !$('#showroom_slide_' + num + ' .swiper-container').hasClass("swiper-container-initialized") ) {
            swiper = new Swiper('#showroom_slide_' + num + ' .swiper-container', {
                slidesPerView: 1,
                loop: true,
                navigation: {
                    nextEl: '.sub-slider__next',
                    prevEl: '.sub-slider__prev',
                },
                pagination: {
                    el: '.swiper-pagination',
                    clickable: true,
                    renderBullet: function (index, className) {
                        return '<span class="' + className + '"></span>';
                    },
                },
            });

            setTimeout(reInit,500);
        }
    });

    if( !$('#showroom_slide_1 .swiper-container').hasClass("swiper-container-initialized") ){
        swiper = new Swiper('#showroom_slide_1 .swiper-container', {
            slidesPerView: 1,
            loop: true,
            navigation: {
                nextEl: '.sub-slider__next',
                prevEl: '.sub-slider__prev',
            },
            pagination: {
                el: '.swiper-pagination',
                clickable: true,
                renderBullet: function (index, className) {
                    return '<span class="' + className + '"></span>';
                },
            },
        });
    };

    var dotArea = $('.main-slider .slick-dots');
    dotArea.wrap('<div class="w-base dot-control"></div>');
    $("<em>0</em>").prependTo('.main-slider .slick-dots>li>button');


    $('.life-slider').slick({
        slidesToShow: 1,
        slidesToScroll: 1,
        autoplay: true,
        autoplaySpeed: 3000,
        arrows: true,
        fade: true,
        asNavFor: '.life-slider-inven'
    });
    var dotArea = $('.life-slider .slick-arrow');
    dotArea.wrap('<div class="w-base dot-control"></div>');
    $("<em>0</em>").prependTo('.main-slider .slick-dots>li>button');


    $('.life-slider-inven').slick({
        slidesToShow: 2,
        slidesToScroll: 1,
        asNavFor: '.life-slider',
        //centerMode: true,
        dots: false,
        arrows: false,
    });

    $('.area-interior').slick({
        dots:true,
        infinite:true,
        autoplay:true,
        autoplaySpeed:3000
    });



    $(document).ready(function() {
        var time = 2;
        var $bar,
            $slick,
            isPause,
            tick,
            percentTime;

        $slick = $('.main-slider');
        $slick.slick({
            arrows: true,
            speed: 1200,
            dots:false,
            arrows:true,
            fade: true,
            infinite: true,
            adaptiveHeight: false
        });

        $bar = $('.slider-progress .progress');

        function startProgressbar() {
            resetProgressbar();
            percentTime = 0;
            isPause = false;
            tick = setInterval(interval, 30);
        }

        function interval() {
            if (isPause === false) {
                percentTime += 1 / (time + 0.1);
                $bar.css({
                    width: percentTime + "%"
                });
                if (percentTime >= 100) {
                    $slick.slick('slickNext');
                    startProgressbar();
                }
            }
        }

        function resetProgressbar() {
            $bar.css({
                width: 0 + '%'
            });
            clearTimeout(tick);
        }

        startProgressbar();

        $('.slick-next, .slick-prev').click(function() {
            startProgressbar();
        });

    });
</script>
</body>
</html>
