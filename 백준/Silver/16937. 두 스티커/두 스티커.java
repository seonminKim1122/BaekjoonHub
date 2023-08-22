import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());

        List<Sticker> stickers = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            stickers.add(new Sticker(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int max = 0;
        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                Sticker sticker1 = stickers.get(i);
                Sticker sticker2 = stickers.get(j);

                int temp = 0;
                // 옆으로 이어 붙이기
                if (sticker1.w + sticker2.w <= W && sticker1.h <= H && sticker2.h <= H) {
                    temp = sticker1.size + sticker2.size;
                    if (max < temp) {
                        max = temp;
                    }
                    continue;
                }
                // 위로 이어 붙이기
                if (sticker1.h + sticker2.h <= H && sticker1.w <= W && sticker2.w <= W) {
                    temp = sticker1.size + sticker2.size;
                    if (max < temp) {
                        max = temp;
                    }
                    continue;
                }

                // 1번째 스티커만 rotate
                sticker1.rotate();
                // 옆으로 이어 붙이기
                if (sticker1.w + sticker2.w <= W && sticker1.h <= H && sticker2.h <= H) {
                    temp = sticker1.size + sticker2.size;
                    if (max < temp) {
                        max = temp;
                    }
                    continue;
                }
                // 위로 이어 붙이기
                if (sticker1.h + sticker2.h <= H && sticker1.w <= W && sticker2.w <= W) {
                    temp = sticker1.size + sticker2.size;
                    if (max < temp) {
                        max = temp;
                    }
                    continue;
                }

                // 2번째 스티커만 rotate
                sticker1.rotate();
                sticker2.rotate();
                // 옆으로 이어 붙이기
                if (sticker1.w + sticker2.w <= W && sticker1.h <= H && sticker2.h <= H) {
                    temp = sticker1.size + sticker2.size;
                    if (max < temp) {
                        max = temp;
                    }
                    continue;
                }
                // 위로 이어 붙이기
                if (sticker1.h + sticker2.h <= H && sticker1.w <= W && sticker2.w <= W) {
                    temp = sticker1.size + sticker2.size;
                    if (max < temp) {
                        max = temp;
                    }
                    continue;
                }

                // 둘 다 rotate
                sticker1.rotate();
                // 옆으로 이어 붙이기
                if (sticker1.w + sticker2.w <= W && sticker1.h <= H && sticker2.h <= H) {
                    temp = sticker1.size + sticker2.size;
                    if (max < temp) {
                        max = temp;
                    }
                    continue;
                }
                // 위로 이어 붙이기
                if (sticker1.h + sticker2.h <= H && sticker1.w <= W && sticker2.w <= W) {
                    temp = sticker1.size + sticker2.size;
                    if (max < temp) {
                        max = temp;
                    }
                }
            }
        }
        System.out.println(max);
    }
}

class Sticker {
    int h;
    int w;
    int size;

    Sticker(int h, int w) {
        this.h = h;
        this.w = w;
        this.size = h * w;
    }

    void rotate() {
        int temp = this.h;
        this.h = this.w;
        this.w = temp;
    }
}