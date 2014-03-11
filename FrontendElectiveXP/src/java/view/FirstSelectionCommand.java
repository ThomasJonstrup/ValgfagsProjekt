/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import backend.DummyBackend;
import electivexp.dto.ElectiveSubjectSummary;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import model.ElectiveSubject;

/**
 *
 * @author Thomas
 */
public class FirstSelectionCommand extends TargetCommand {

    public FirstSelectionCommand(String target) {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request) {
        
//        DummyBackend dummy = new DummyBackend();
//        ArrayList<ElectiveSubjectSummary> electiveSubjects = new ArrayList<>();
//        electiveSubjects = dummy.getElectivSubjects();
        request.setAttribute("subjects", Factory.getInstance().getManager().getSubjects());
        
        return super.execute(request); //To change body of generated methods, choose Tools | Templates.
    }

    
}
