window.onload = function(){

    let numberName;
    let roadName;
    let buildingCode;

    //위도
    let latitude;

    //경도
    let longitude;

    document.getElementById("address_kakao").addEventListener("click", function(){ //주소입력칸을 클릭하면
        //카카오 지도 발생
        new daum.Postcode({
            oncomplete: function(data) {

                numberName = data.address;
                roadName = data.autoRoadAddress;
                buildingCode = data.buildingCode;

                document.getElementById("address_kakao").value = numberName; // 주소 넣기
                //document.querySelector("input[name=address_detail]").focus(); //상세입력 포커싱

                numberName = data.address;
                roadName = data.autoRoadAddress;
                buildingCode = data.buildingCode;

                document.getElementById("address_kakao").value = numberName; // 주소 넣기
                document.querySelector("input[name=address_detail]").focus(); //상세입력 포커싱



                Promise.resolve(data).then(o => {
                    const { address } = data;

                    return new Promise((resolve, reject) => {
                        const geocoder = new kakao.maps.services.Geocoder();

                        geocoder.addressSearch(address, (result, status) =>{
                            if(status === kakao.maps.services.Status.OK){
                                const { x, y } = result[0];
                                resolve({ lat: y, lon: x })
                            }else{
                                reject();
                            }
                        });
                    })
                }).then(result => {
                    // 위, 경도 결과 값
                    latitude = result.lat;
                    longitude = result.lon;

                    // 비동기 통신
                    //XMLHttpRequest 객체 생성
                    var xhr = new XMLHttpRequest();
                    //요청을 보낼 방식, 주소, 비동기여부 설정
                    xhr.open('GET', '/realestate', true);
                    //요청 전송
                    xhr.send();
                    //통신후 작업
                    xhr.onload = () => {
                        //통신 성공
                        if (xhr.status == 200) {
                            console.log(xhr.response);
                            console.log("통신 성공");
                        } else {
                            //통신 실패
                            console.log("통신 실패");
                        }
                    }
                });

            }
        }).open();
    });
}