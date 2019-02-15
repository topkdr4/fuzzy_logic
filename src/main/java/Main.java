import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;
import java.util.function.Function;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class Main {


    @AllArgsConstructor
    private enum ChlorineCount implements Function<Double, Double> {
        ACCEPTABLE("Приемлемое",  value -> {
            if (value <= 400)
                return 1d;

            if (value >= 600)
                return 0d;

            return value / 600d;
        }),
        HIGH("Высокое",  value -> {
            if (value <= 400)
                return 0d;

            if (value >= 600)
                return 1d;


            return value / 600d;
        })
        ;

        private final String count;
        private final Function<Double, Double> fuzzyFunc;


        @Override
        public Double apply(Double t) {
            return fuzzyFunc.apply(t);
        }
    }


    @AllArgsConstructor
    private enum TurbidityCount implements Function<Double, Double> {
        LOW("Низкое", value -> {
            if (value <= 350)
                return 1d;

            if (value >= 500)
                return 1d;

            return value / 500d;
        }),
        HIGH("Высокое", value -> {
            if (value >= 500)
                return 1d;

            if (value <= 350)
                return 0d;

            return value / 500d;
        })
        ;

        private final String count;
        private final Function<Double, Double> fuzzyFunc;


        @Override
        public Double apply(Double t) {
            return fuzzyFunc.apply(t);
        }
    }


    @AllArgsConstructor
    private enum MicroCount implements Function<Double, Double> {
        LOW("Низкое", value -> {
            if (value <= 350)
                return 1d;

            if (value >= 500)
                return 0d;

            return value / 500d;
        }),
        ACCEPTABLE("Приемлемое", value -> {
            if (value <= 350)
                return 0d;

            if (value >= 1000)
                return 0d;

            if (value <= 500)
                return value / 500d;

            if (value <= 800)
                return 1d;

            return value / 1000d;
        }),
        HIGH("Высокое", value -> {
            if (value <= 800)
                return 0d;

            if (value >= 1000)
                return 1d;

            return value / 1000d;
        })
        ;

        private final String count;
        private final Function<Double, Double> fuzzyFunc;


        @Override
        public Double apply(Double t) {
            return fuzzyFunc.apply(t);
        }
    }


    @AllArgsConstructor
    private enum WaterCount implements Function<Double, Double> {
        NOT_HIGH("НЕ высокое", value -> {
            if (value <= 800)
                return 1d;

            if (value >= 1000)
                return 0d;

            return value / 1000d;
        }),
        HIGH("Высокое", value -> {
            if (value <= 800)
                return 0d;

            if (value >= 1000)
                return 1d;

            return value / 1000d;
        })
        ;

        private final String count;
        private final Function<Double, Double> fuzzyFunc;


        @Override
        public Double apply(Double t) {
            return fuzzyFunc.apply(t);
        }
    }


    @AllArgsConstructor
    private enum SpeedCoun implements Function<Double, Double> {
        NOT_HIGH("НЕ высокое", value -> {
            if (value <= 800)
                return 1d;

            if (value >= 1000)
                return 0d;

            return value / 1000d;
        }),
        HIGH("Высокое", value -> {
            if (value <= 800)
                return 0d;

            if (value >= 1000)
                return 1d;

            return value / 1000d;
        })
        ;

        private final String count;
        private final Function<Double, Double> fuzzyFunc;


        @Override
        public Double apply(Double t) {
            return fuzzyFunc.apply(t);
        }
    }


    //*********************************************************************************

    @AllArgsConstructor
    private enum ResultWater implements Function<Double, Double> {
        NEGATIVE("Отрицательное", value -> {
            if (value <= -150)
                return 0d;

            if (value == -70)
                return 1d;

            if (value >= 20)
                return 0d;

            return Math.abs(value / 20);
        }),
        POSITIVE("Положительное", value -> {
            if (value <= -20)
                return 0d;

            if (value == 70)
                return 1d;

            if (value >= 150)
                return 0d;

            return value / 150d;
        }),
        SUPER_POSITIVE("Положительное большое", value -> {
            if (value <= 100)
                return 0d;

            if (value == 230)
                return 1d;

            if (value >= 300)
                return 0d;

            return value / 300d;
        })
        ;


        private final String count;
        private final Function<Double, Double> fuzzyFunc;


        @Override
        public Double apply(Double t) {
            return fuzzyFunc.apply(t);
        }
    }


    @AllArgsConstructor
    private enum ResultChlorine implements Function<Double, Double> {
        NEGATIVE("Отрицательное", value -> {
            if (value <= -150)
                return 0d;

            if (value == -70)
                return 1d;

            if (value >= 20)
                return 0d;

            return Math.abs(value / 20);
        }),
        POSITIVE("Положительное", value -> {
            if (value <= -20)
                return 0d;

            if (value == 70)
                return 1d;

            if (value >= 150)
                return 0d;

            return value / 150d;
        }),
        SUPER_POSITIVE("Положительное большое", value -> {
            if (value <= 100)
                return 0d;

            if (value == 230)
                return 1d;

            if (value >= 300)
                return 0d;

            return value / 300d;
        })
        ;


        private final String count;
        private final Function<Double, Double> fuzzyFunc;


        @Override
        public Double apply(Double t) {
            return fuzzyFunc.apply(t);
        }
    }


    @AllArgsConstructor
    private enum ResultSpeed implements Function<Double, Double> {
        NEGATIVE("Отрицательное", value -> {
            if (value <= -150)
                return 0d;

            if (value == -70)
                return 1d;

            if (value >= 20)
                return 0d;

            return Math.abs(value / 20);
        }),
        POSITIVE("Положительное", value -> {
            if (value <= -20)
                return 0d;

            if (value == 70)
                return 1d;

            if (value >= 150)
                return 0d;

            return value / 150d;
        })
        ;

        private final String count;
        private final Function<Double, Double> fuzzyFunc;


        @Override
        public Double apply(Double t) {
            return fuzzyFunc.apply(t);
        }
    }


    //*********************************************************************************


    @Getter
    @AllArgsConstructor
    private static class InputData {
        /**
         * Количество микроорганизмов
         */
        private final double micro_ratio;
        /**
         * Остаточная концентрация хлорина
         */
        private final double cl_ratio;
        /**
         * Прозрачность воды
         */
        private final double turbidity;
        /**
         * Скорость ленты конвейера
         */
        private final double speed;
        /**
         * Поток воды
         */
        private final double water_f;


        private static InputData build() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Кол-во микроорганизмов:");
            double micro_ratio = scanner.nextDouble();

            System.out.println("Остаточная концентрация хлорина:");
            double cl_ratio = scanner.nextDouble();

            System.out.println("Прозрачность воды:");
            double turbidity = scanner.nextDouble();

            System.out.println("Скорость ленты конвейера:");
            double speed = scanner.nextDouble();

            System.out.println("Поток воды");
            double water_f = scanner.nextDouble();

            return new InputData(micro_ratio, cl_ratio, turbidity, speed, water_f);
        }

    }


    @Getter
    @Setter
    private static class OutoputData {
        /**
         * Изменение потока воды
         */
        private double water_f_var;
        /**
         * Изменение потока хлорина
         */
        private double cl_f_var;
        /**
         * Изменение скорости
         */
        private double speed_var;
    }


    public static void main(String[] args) {
        InputData inputData = InputData.build();
    }

}
