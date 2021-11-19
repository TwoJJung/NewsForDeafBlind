package com.ssuOpensource.NewForBlind.common;

import com.voicerss.tts.*;
import java.io.FileOutputStream;

public class makeSound
{
    private final VoiceProvider tts;
    private final String path;
    private final String content;

    makeSound(String apiKey, String path, String content) {
        tts = new VoiceProvider(apiKey);
        this.path = path;
        this.content = content;
    }

    public static String test =         //테스트용 문자열
            "Abc 123445" +
            "test의 값은 123" +
            "루카스씨 고향은 어디예요? 고향은 어떤 곳이에요?" +
            "한국에 언제 왔어요? 왜 한국에 왔어요?" +
            "오늘 저녁에 뭘 하려고 해요? 누구와 같이 할 거예요?" +
            "고향 친구에게 선물을 하려고 해요. 뭐가 좋을까요?" +
            "일요일은 친구 생일이에요. 무슨 선물을 할 거예요?" +
            "한국에는 얼마 동안 있을 거예요?" +
            "좋아하는 음식이 뭐예요? 그 음식을 왜 좋아해요?" +
            "지금 식당에 갈 거예요. 무슨 음식을 주문할까요?" +
            "루카스씨 취미가 뭐예요?" +
            "영어와 일본어를 할 줄 알아요?" +
            "자전거를 탈 줄 알아요? 그럼 오토바이를 탈 줄 알아요?" +
            "백화점에 갈 거예요. 무엇을 사고 싶어요?" +
            "백화점에서 티셔츠를 사고 싶어요. 어떤 색깔을 사면 좋을까요?" +
            "까만색 반바지를 샀어요. 티셔츠를 어떤 색깔을 사면 좋을까요?" +
            "부산에 가 봤어요? 어땠어요?" +
            "서울은 무엇으로 유명한 도시예요?" +
            "이번 주말에 뭐 할 거예요?" +
            "고향 친구가 한국에 오면 어디에 같이 가고 싶어요?" +
            "고향 친구가 한국에 오면 무슨 음식을 같이 먹을 거예요?" +
            "이번 여름 방학에 뭐 할 거에요?" +
            "한국에서 어디를 여행해 봤어요?그곳이 어땠어요?" +
            "한국에서 가장 재미있는 일은 뭐예요?" +
            "한국에서 가장 힘든 일은 뭐예요?" +
            "우리 반 친구들이 어때 보여요?" +
            "친구 생일 파티에 가요. 뭘 준비해 갈 거에요?" +
            "친구를 우리 집에 초대했어요. 뭘 준비할 거예요?" +
            "수업 시간에 무엇을 해도 돼요?" +
            "수업 시간에 무엇을 해면 안 돼요?" +
            "한국어를 잘하고 싶어요. 어떻 게 하면 좋을까요?" +
            "여행을 가고 싶어요. 무엇을 준비하면 좋을까요?";

    public void makeTTS() {
        VoiceParameters params = new VoiceParameters(content, Languages.Korean);
        params.setCodec(AudioCodec.MP3);                                        //다른 코덱은 다른 인코딩 방식 사용해야함
        params.setFormat(AudioFormat.Format_8KHZ.AF_8khz_16bit_mono);         //음질 올리면 용량 올라감
        params.setBase64(false);
        params.setSSML(false);
        params.setRate(1);          //낮추면 느려짐

        byte[] voice;
        try {
            voice = tts.speech(params);         //byte 배열로 .wav 내용 생성
        } catch (Exception e) {
            System.out.println("Error: Cannot create tts");
            e.printStackTrace();
            return;
        }
        writeFile(voice);       //byte 배열 리턴, 이후 용도에 따라 변경
    }

    private void writeFile(byte[] b) {      //파일에 저장
        try {
            FileOutputStream fos = new FileOutputStream(path);

            fos.write(b);
            fos.flush();
            fos.close();
        } catch (Exception e) {}
    }
}



