package com.javarush.task.task24.task2405;

/* 
Black box
*/
public class Solution implements Action {
    public static int countActionObjects;

    private int param; // зачем нужна это херня?

    private Action solutionAction = new Action() {
        //!!!!! Changes can be here
        //!!!!! Изменения могут быть тут

        public void someAction() {
            //!!!!! All changes have to be here
            //!!!!! Все изменения должны быть только тут
            if(param > 0) {
                for(int i = param; i >= 1; i--, param--)
                    System.out.println(i);

                new FirstClass() {
                    @Override
                    public Action getDependantAction() {
                        SecondClass inner = new SecondClass() {
                            public void someAction() {
                                super.someAction();
                            }
                        };
                        return inner;
                    }
                }.someAction();
            }

            SecondClass secondClass = new SecondClass() {
                public void someAction() {
                    System.out.print(sb.toString());
                    specialAction();
                }

                private void specialAction() {
                    System.out.println(SPECIFIC_ACTION_FOR_ANONYMOUS_SECOND_CLASS_PARAM + param);
                }
            };

            secondClass.someAction();
        }
    };


    public Solution(int param) {
        this.param = param;
    }

    @Override
    public void someAction() {
        solutionAction.someAction();
    }

    /**
     * 5
     * 4
     * 3
     * 2
     * 1
     * class FirstClass, method someAction
     * class SecondClass, method someAction
     * Specific action for anonymous SecondClass, param = 0
     * Count of created Action objects is 2
     * class SecondClass, method someAction
     * Specific action for anonymous SecondClass, param = -1
     * Count of created Action objects is 3
     */
    public static void main(String[] args) {
        Solution solution = new Solution(5);
        solution.someAction();
        System.out.println("Count of created Action objects is " + countActionObjects);

        solution = new Solution(-1);
        solution.someAction();
        System.out.println("Count of created Action objects is " + countActionObjects);
    }
}
