import java.awt.color.ICC_ColorSpace;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Five {
    public boolean[] solution(String program, String[] flag_rules, String[] commands) {
        boolean[] answer = new boolean[commands.length];

        Program tempProgram = new Program(program, flag_rules);
        for(String key : tempProgram.getFlagMap().keySet()) {
            System.out.println(key);
        }


        for(int i=0; i<commands.length; i++) {
            Command command = new Command(commands[i], tempProgram);
            if(command.checkCommand()) {
                answer[i] = true;
            }
            else answer[i] = false;
        }

        return answer;
    }

}

class Command {
    String command;
    Program program;

    public Command(String _command, Program _program) {
        command = _command;
        program = _program;
    }

    /*
    명령어 조건 체크 메인 로직
    */
    public boolean checkCommand() {
        String[] arrCmd = command.split(" ");
        List<String> usedArgsList = new ArrayList<>();

        // 첫번째 문자가 Program이 아니면 false
        if(!arrCmd[0].equals(program.getName())) {
            return false;
        }

        for(int i=1; i<arrCmd.length; i++) {
            // 1. flag인 경우
            if(arrCmd[i].contains("-")) {

                // flag_map에 존재하지 않는 flag일 경우
                if(!program.getFlagMap().containsKey(arrCmd[i])) {

                    //alias에도 없는 경우 잘못된 명령어
                    if(!program.getAliasMap().containsKey(arrCmd[i])) return false;

                    //alias에 있는 경우 본래 명령어로 변경
                    arrCmd[i] = program.getAliasMap().get(arrCmd[i]);
                }

                // flag가 중복된 경우 잘못된 명령어
                if(usedArgsList.contains(arrCmd[i])) return false;
                usedArgsList.add(arrCmd[i]);

                // flag에 따른 인자 타입 체킹
                switch (program.getFlagMap().get(arrCmd[i])) {
                    case "STRING" :
                        if(!checkString(arrCmd[i+1])) return false;
                    case "NUMBER" :
                        if(!checkNumber(arrCmd[i+1])) return false;
                    case "NULL" :
                        return true;
                    default :
                        return true;
                }
            }
        }

        return true;
    }

    /*
    "Number" 타입 인자 체크
     */
    public boolean checkNumber(String arg){
        for(int i=0; i<arg.length(); i++) {
            if(arg.charAt(i) >= 48 && arg.charAt(i) <= 57) continue;
            return false;
        }

        return true;
    }

    /*
    "String" 타입 인자 체크
     */
    public boolean checkString(String arg) {
        for(int i=0; i<arg.length(); i++) {
            if(arg.charAt(i) >= 65 && arg.charAt(i) <= 90) continue;
            else if(arg.charAt(i) >= 97 && arg.charAt(i) <= 122) continue;
            else return false;
        }
        return true;
    }

    /*
    "NULL" 타입 인자 체크
     */
    public boolean checkNull(String arg) {
        return arg.length() == 0 ? true : false;
    }

}

class Program {
    private String name;
    private String[] flag_rules;
    private HashMap<String, String> aliasMap = new HashMap<>();
    private HashMap<String, String> flagMap = new HashMap<>();

    public String getName() {
        return name;
    }

    public HashMap<String, String> getFlagMap() {
        return flagMap;
    }

    public HashMap<String, String> getAliasMap() {
        return aliasMap;
    }

    public Program(String _name, String[] _flag_rules) {
        name = _name;
        flag_rules = _flag_rules;
        parseFlagRules();
    }

    public void parseFlagRules() {
        for(int i=0; i<flag_rules.length; i++) {
            String[] flag_rule = flag_rules[i].split(" ");

            // ALIAS 체크
            if(flag_rule[1].equals("ALIAS")) {
                aliasMap.put(flag_rule[2], flag_rule[0]);
            }
            else {
                flagMap.put(flag_rule[0], flag_rule[1]);
            }
        }
    }
}
