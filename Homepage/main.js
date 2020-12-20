//즉시 실행되는 함수 구문
// (()=>{
// })();

//(function(){       })();
(function () {

    let yOffset;
    let currentScene;
    let prevScrollHeight;
    let enterScene;

    const sceneinfo = [
        {
            //1번째 section
            type: 'sticky',
            heightNum: 5,
            scrollHeight: 0,  //지금 섹션 화면의 스크롤의 max값
            objs: {
                container: document.querySelector('#scroll-section-0'),
                messageA: document.querySelector('#scroll-section-0 .main-message.a'),
                messageB: document.querySelector('#scroll-section-0 .main-message.b'),
                messageC: document.querySelector('#scroll-section-0 .main-message.c'),
                messageD: document.querySelector('#scroll-section-0 .main-message.d')
            },
            value: {
                messageA_opacity_in: [0, 1, { start: 0.1, end: 0.2 }],
                messageA_opacity_out: [1, 0, { start: 0.25, end: 0.3 }],
                messageB_opacity_in: [0, 1, { start: 0.3, end: 0.4 }],
                messageB_opacity_out: [1, 0, { start: 0.45, end: 0.5 }],
                messageC_opacity_in: [0, 1, { start: 0.5, end: 0.6 }],
                messageC_opacity_out: [1, 0, { start: 0.65, end: 0.7 }],
                messageD_opacity_in: [0, 1, { start: 0.7, end: 0.8 }],
                messageD_opacity_out: [1, 0, { start: 0.85, end: 0.9 }],
                messageA_translate_in: [20, 0, { start: 0.1, end: 0.2 }],
                messageB_translate_in: [20, 0, { start: 0.3, end: 0.4 }],
                messageC_translate_in: [20, 0, { start: 0.5, end: 0.6 }],
                messageD_translate_in: [20, 0, { start: 0.7, end: 0.8 }],
                messageA_translate_out: [0, -20, { start: 0.25, end: 0.3 }],
                messageB_translate_out: [0, -20, { start: 0.45, end: 0.5 }],
                messageC_translate_out: [0, -20, { start: 0.65, end: 0.7 }],
                messageD_translate_out: [0, -20, { start: 0.85, end: 0.9 }]
            }
        },
        {
            //2번째 section
            type: 'normal',
            heightNum: 5,
            scrollHeight: 0,
            objs: {
                container: document.querySelector('#scroll-section-1')
            }
        },
        {
            //3번째 section
            type: 'sticky',
            heightNum: 5,
            scrollHeight: 0,  //지금 섹션 화면의 스크롤의 max값
            objs: {
                container: document.querySelector('#scroll-section-2'),
                messageA: document.querySelector('#scroll-section-2 .main-message.a'),
                messageB: document.querySelector('#scroll-section-2 .desc-message.b'),
                messageC: document.querySelector('#scroll-section-2 .desc-message.c')
            },
            value: {
                messageA_opacity_in: [0, 1, { start: 0.15, end: 0.2 }],
                messageB_opacity_in: [0, 1, { start: 0.5, end: 0.55 }],
                messageC_opacity_in: [0, 1, { start: 0.77, end: 0.82 }],
                messageA_opacity_out: [1, 0, { start: 0.3, end: 0.35 }],
                messageB_opacity_out: [1, 0, { start: 0.58, end: 0.63 }],
                messageC_opacity_out: [1, 0, { start: 0.85, end: 0.9 }],
                messageA_translate_in: [20, 0, { start: 0.15, end: 0.2 }],
                messageB_translate_in: [30, 0, { start: 0.5, end: 0.55 }],
                messageC_translate_in: [30, 0, { start: 0.77, end: 0.82 }],
                messageA_translate_out: [0, -20, { start: 0.3, end: 0.35 }],
                messageB_translate_out: [0, -20, { start: 0.58, end: 0.63 }],
                messageC_translate_out: [0, -20, { start: 0.85, end: 0.9 }]
            }
        }
    ];

    function setlayout() {
        for (let i = 0; i < sceneinfo.length; i++) {
            if (sceneinfo[i].type === 'sticky') {
                sceneinfo[i].scrollHeight = sceneinfo[i].heightNum * window.innerHeight;
            }
            else if (sceneinfo[i].type === 'normal') {
                sceneinfo[i].scrollHeight = sceneinfo[i].objs.container.offsetHeight;
            }
            sceneinfo[i].objs.container.style.height = `${sceneinfo[i].scrollHeight}px`;
        }

        yOffset = window.pageYOffset;
        let totalScrollHeight = 0;

        for (let i = 0; i < sceneinfo.length; i++) {
            totalScrollHeight += sceneinfo[i].scrollHeight;
            if (totalScrollHeight >= yOffset) {
                currentScene = i;
                break;
            }
        }
        document.body.setAttribute('id', `show-scene-${currentScene}`);
    }

    function scrollAnimation() {
        const currentyOffset = yOffset - prevScrollHeight;
        const scrollHeight = sceneinfo[currentScene].scrollHeight;
        const offsetRatio = currentyOffset / scrollHeight;
        const objs = sceneinfo[currentScene].objs;
        const values = sceneinfo[currentScene].value;

        console.log(offsetRatio);
        console.log(currentyOffset);

        switch (currentScene) {
            case 0:
                if (offsetRatio < 0.22) {
                    sceneinfo[0].objs.messageA.style.opacity = calculValue(currentyOffset, values.messageA_opacity_in, scrollHeight);
                    sceneinfo[0].objs.messageA.style.transform = `translateY(${calculValue(currentyOffset, values.messageA_translate_in, scrollHeight)}%)`;
                } else {
                    sceneinfo[0].objs.messageA.style.opacity = calculValue(currentyOffset, values.messageA_opacity_out, scrollHeight);
                    sceneinfo[0].objs.messageA.style.transform = `translateY(${calculValue(currentyOffset, values.messageA_translate_out, scrollHeight)}%)`;
                }

                if (offsetRatio < 0.42) {
                    sceneinfo[0].objs.messageB.style.opacity = calculValue(currentyOffset, values.messageB_opacity_in, scrollHeight);
                    sceneinfo[0].objs.messageB.style.transform = `translateY(${calculValue(currentyOffset, values.messageB_translate_in, scrollHeight)}%)`;
                } else {
                    sceneinfo[0].objs.messageB.style.opacity = calculValue(currentyOffset, values.messageB_opacity_out, scrollHeight);
                    sceneinfo[0].objs.messageB.style.transform = `translateY(${calculValue(currentyOffset, values.messageB_translate_out, scrollHeight)}%)`;
                }
                if (offsetRatio < 0.62) {
                    sceneinfo[0].objs.messageC.style.opacity = calculValue(currentyOffset, values.messageC_opacity_in, scrollHeight);
                    sceneinfo[0].objs.messageC.style.transform = `translateY(${calculValue(currentyOffset, values.messageC_translate_in, scrollHeight)}%)`;
                } else {
                    sceneinfo[0].objs.messageC.style.opacity = calculValue(currentyOffset, values.messageC_opacity_out, scrollHeight);
                    sceneinfo[0].objs.messageC.style.transform = `translateY(${calculValue(currentyOffset, values.messageC_translate_out, scrollHeight)}%)`;
                }
                if (offsetRatio < 0.82) {
                    sceneinfo[0].objs.messageD.style.opacity = calculValue(currentyOffset, values.messageD_opacity_in, scrollHeight);
                    sceneinfo[0].objs.messageD.style.transform = `translateY(${calculValue(currentyOffset, values.messageD_translate_in, scrollHeight)}%)`;
                } else {
                    sceneinfo[0].objs.messageD.style.opacity = calculValue(currentyOffset, values.messageD_opacity_out, scrollHeight);
                    sceneinfo[0].objs.messageD.style.transform = `translateY(${calculValue(currentyOffset, values.messageD_translate_out, scrollHeight)}%)`;
                }

                break;
            case 1:
                break;
            case 2:
                if (offsetRatio < 0.22) {
                    sceneinfo[2].objs.messageA.style.opacity = calculValue(currentyOffset, values.messageA_opacity_in, scrollHeight);
                    sceneinfo[2].objs.messageA.style.transform = `translateY(${calculValue(currentyOffset, values.messageA_translate_in, scrollHeight)}%)`;

                } else {
                    sceneinfo[2].objs.messageA.style.opacity = calculValue(currentyOffset, values.messageA_opacity_out, scrollHeight);
                    sceneinfo[2].objs.messageA.style.transform = `translateY(${calculValue(currentyOffset, values.messageA_translate_out, scrollHeight)}%)`;
                }
                if (offsetRatio < 0.57) {
                    sceneinfo[2].objs.messageB.style.opacity = calculValue(currentyOffset, values.messageB_opacity_in, scrollHeight);
                    sceneinfo[2].objs.messageB.style.transform = `translateY(${calculValue(currentyOffset, values.messageB_translate_in, scrollHeight)}%)`;
                } else {
                    sceneinfo[2].objs.messageB.style.opacity = calculValue(currentyOffset, values.messageB_opacity_out, scrollHeight);
                    sceneinfo[2].objs.messageB.style.transform = `translateY(${calculValue(currentyOffset, values.messageB_translate_out, scrollHeight)}%)`;
                }
                if (offsetRatio < 0.84) {
                    sceneinfo[2].objs.messageC.style.opacity = calculValue(currentyOffset, values.messageC_opacity_in, scrollHeight);
                    sceneinfo[2].objs.messageC.style.transform = `translateY(${calculValue(currentyOffset, values.messageC_translate_in, scrollHeight)}%)`;
                } else {
                    sceneinfo[2].objs.messageC.style.opacity = calculValue(currentyOffset, values.messageC_opacity_out, scrollHeight);
                    sceneinfo[2].objs.messageC.style.transform = `translateY(${calculValue(currentyOffset, values.messageC_translate_out, scrollHeight)}%)`;
                }
                break;
        }
    }

    function calculValue(currentyOffset, value, scrollHeight) {
        let start = value[2].start;
        let end = value[2].end;
        let localStart = scrollHeight * start;
        let localEnd = scrollHeight * end;
        let localYoffset = currentyOffset - localStart;

        let part = localEnd - localStart;
        let Real;


        if (currentyOffset >= localStart && currentyOffset <= localEnd && value[0] === 0) {
            Real = localYoffset / part * value[1];

        } else if (currentyOffset > localEnd) {
            Real = value[1];

        } else if (currentyOffset < localStart) {
            Real = value[0];
        }
        else {
            Real = (1 - (localYoffset / part)) * value[0];
        }
        console.log("Real : " + Real);
        return Real;

    }

    function calcValue(invalues, outvalues, scrollHeight) {
        let fadeinstart = invalues[2].start; //0
        let fadeinend = invalues[2].end; //0.5
        let fadeoutstart = outvalues[2].start; //0.7
        let fadeoutend = outvalues[2].end; //1

        let result = yOffset / scrollHeight;

        console.log("yoffset" + yOffset);
        console.log("result : " + result)

        if (result <= fadeinstart) {
            return invalues[0];
        }
        else if (result <= fadeinend) {     //if(result <= 0.5)
            result = result * (invalues[1] / (fadeinend - fadeinstart));
            return result;
        }
        else if (result <= fadeoutstart) {     //if(result<=0.7)
            return invalues[1];
        }
        else if (result <= fadeoutend) {      //if(result>0.7)
            result = (invalues[1] - ((result - fadeoutstart))) * (outvalues[0]) / (fadeoutend - fadeoutstart);
            console.log("real result : " + result);
            return result;
        }

        return outvalues[1];
    }

    function Loop() {
        prevScrollHeight = 0;
        enterScene = false;

        for (let i = 0; i < currentScene; i++) {
            prevScrollHeight += sceneinfo[i].scrollHeight;
        }

        if (yOffset >= sceneinfo[currentScene].scrollHeight + prevScrollHeight) {
            currentScene++;
            document.body.setAttribute('id', `show-scene-${currentScene}`);

        }
        else if (yOffset < prevScrollHeight) {
            if (currentScene === 0) return;
            enterScene = true;
            currentScene--;
            document.body.setAttribute('id', `show-scene-${currentScene}`);

        }
        if (enterScene) return;

        scrollAnimation();
    }

    window.addEventListener('scroll', function () {
        yOffset = parseInt(pageYOffset);
        Loop();
    });

    window.addEventListener('load', setlayout);
    window.addEventListener('resize', setlayout);
    setlayout();
})();