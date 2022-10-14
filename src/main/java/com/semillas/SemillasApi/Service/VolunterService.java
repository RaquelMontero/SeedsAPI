package com.semillas.SemillasApi.Service;


import com.semillas.SemillasApi.DTO.Format.*;
import com.semillas.SemillasApi.DTO.VolunterDTO;
import com.semillas.SemillasApi.Entities.Role;
import com.semillas.SemillasApi.Entities.Seeds.Contributor;
import com.semillas.SemillasApi.Entities.User;
import com.semillas.SemillasApi.Entities.Volunter;
import com.semillas.SemillasApi.Enums.ColorCode;
import com.semillas.SemillasApi.Enums.ContributorState;
import com.semillas.SemillasApi.Enums.RolName;
import com.semillas.SemillasApi.Enums.Status;
import com.semillas.SemillasApi.Repository.UserRepository;
import com.semillas.SemillasApi.Repository.VolunterRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.*;

@Service
public class VolunterService {

    @Inject
    VolunterRepository volunterRepository;

    @Inject
    UserRepository userRepository;

    public Table findAllVolunter(){
        Table resultTable = this.getVoluntersInformat(volunterRepository.findAll(), false);
        /*volunters.removeIf(p -> p.getStatus().equals(Status.INACTIVO));
        for (Volunter volunter : volunters) {
            VolunterDTO vacationDTO = new VolunterDTO(volunter);
            voluntersDTOS.add(vacationDTO);
        }*/
        return resultTable;
    }
    public Table findAlltrackingVolunters(){
        List<Volunter> volunters =  volunterRepository.findAll();
        volunters.removeIf(v -> !this.gotTheRol(RolName.R_SEGUIMIENTOS,v.getRoles()));
        Table resultTable = this.getVoluntersInformat(volunters, true);
        return resultTable;
    }
    public boolean gotTheRol(RolName rolName, List<Role> roles){
        roles.removeIf(r -> !(r.getRole_name().equals(rolName)));
        return roles.size() > 0;
    }
    private Table getVoluntersInformat(List<Volunter> volunters, Boolean isTracking){
        List<TableRow> resultList = new ArrayList<TableRow>();
        int index=1;
        for (Volunter volunter: volunters){
            List<Cell> cells = new ArrayList<Cell>();
            cells.add(new Cell(
                    new CellHeader("No",0,"Integer",false,null),
                    new CellProperty(null,false,null,null),
                    new ArrayList<CellContent>(
                            Arrays.asList(
                                new CellContent("text",null,null,false,null,null,String.valueOf(index),null)
                            )
                    )
            ));
            cells.add(new Cell(
                    new CellHeader("Nombre",0,"String",true,null),
                    new CellProperty(null,false,null,null),
                    new ArrayList<CellContent>(
                            Arrays.asList(
                                    new CellContent("text",
                                            null,null,false,
                                            null,null,
                                            volunter.getUser().getName() + ' '+volunter.getUser().getLastname(),
                                            null)
                            )
                    )
            ));
            cells.add(new Cell(
                    new CellHeader("Correo",0,"String",true,null),
                    new CellProperty(null,false,null,null),
                    new ArrayList<CellContent>(
                            Arrays.asList(
                                    new CellContent("text",
                                            null,null,false,
                                            null,null, volunter.getUser().getEmail(),
                                            null)
                            )
                    )
            ));
            cells.add(new Cell(
                    new CellHeader("Responsabilidades",0,"String",false,null),
                    new CellProperty(null,false,null,null),
                    new ArrayList<CellContent>(this.getVolunterRoles(volunter.getRoles()))
            ));
            cells.add(new Cell(
                    new CellHeader("Ingreso",0,"Date",true,null),
                    new CellProperty(null,false,null,null),
                    new ArrayList<CellContent>(
                            Arrays.asList(
                                    new CellContent("text",
                                            null,null,false,
                                            null,null, volunter.getEntry_date().toString(),
                                            null)
                            )
                    )
            ));
            cells.add(new Cell(
                    new CellHeader("Opciones",0,"String",false,null),
                    new CellProperty(null,false,null,null),
                    new ArrayList<CellContent>(this.getSeedActions(volunter,isTracking)
                            /*Arrays.asList(
                                    new CellContent("iconAccion",
                                            "edit", ColorCode.EDIT.value, true,
                                            "editVolunter","Editar", null,
                                            new ArrayList<CellParam>(Arrays.asList(
                                             new CellParam("volunterId",volunter.getVolunter_id().toString())
                                            ))),
                                    new CellContent("iconAccion",
                                            "delete",ColorCode.DELETE.value, true,
                                            "deleteVolunter","Eliminar", null,
                                            new ArrayList<CellParam>(Arrays.asList(
                                                    new CellParam("volunterId",volunter.getVolunter_id().toString())
                                            ))),
                                    new CellContent("iconAccion",
                                            "remove_red_eye",ColorCode.VIEW.value, true,
                                            "seeVolunter","Ver Info", null,
                                            new ArrayList<CellParam>(Arrays.asList(
                                                    new CellParam("volunterId",volunter.getVolunter_id().toString())
                                            )))
                            )*/
                    )
            ));
            resultList.add(new TableRow(cells));
            index++;
        }
        return new Table(resultList);
    }

    private List<CellContent> getVolunterRoles(List<Role> roles){
        List<CellContent> contents = new ArrayList<>();
        for (Role role : roles){
            if(role.getRole_name().equals(RolName.R_PRINCIPAL)){
                contents.add(new CellContent(
                        "chipContent",
                        null,ColorCode.R_PRINCIPAL_COLOR.value,false,
                        null,null, role.getRole_name().value,
                        null
                ));
            }
            else if(role.getRole_name().equals(RolName.R_REGISTROS)){
                contents.add(new CellContent(
                        "chipContent",
                        null,ColorCode.R_REGISTROS_COLOR.value, false,
                        null,null, role.getRole_name().value,
                        null
                ));
            }
            else if(role.getRole_name().equals(RolName.R_SEGUIMIENTOS)){
                contents.add(new CellContent(
                        "chipContent",
                        null,ColorCode.R_SEGUIMIENTOS_COLOR.value, false,
                        null,null, role.getRole_name().value,
                        null
                ));
            }
            else if(role.getRole_name().equals(RolName.R_SOUVENIRS)){
                contents.add(new CellContent(
                        "chipContent",
                        null,ColorCode.R_SOUVENIRS_COLOR.value, false,
                        null,null, role.getRole_name().value,
                        null
                ));
            }
        }
        return contents;
    }

    private List<CellContent> getSeedActions(Volunter volunter, Boolean isTracking){
        List<CellContent> contents = new ArrayList<>();
        if (isTracking){
            contents.add(new CellContent("iconAccion",
                    "group", ColorCode.VIEW_ASSIGNED_SEEDS.value, true,
                    "ViewAssignedSeeds","Ver semillas asignadas", null,
                    new ArrayList<CellParam>(Arrays.asList(
                            new CellParam("volunterId",volunter.getVolunter_id().toString())
                    ))
            ));
            contents.add(new CellContent("iconAccion",
                    "group_add", ColorCode.ASSIGN_SEED.value, true,
                    "AssignSeed","Asignar semilla", null,
                    new ArrayList<CellParam>(Arrays.asList(
                            new CellParam("volunterId",volunter.getVolunter_id().toString())
                    ))
            ));
        }
        else {
            contents.add(new CellContent("iconAccion",
                    "edit", ColorCode.EDIT.value, true,
                    "editVolunter","Editar", null,
                    new ArrayList<CellParam>(Arrays.asList(
                            new CellParam("volunterId",volunter.getVolunter_id().toString())
                    ))));
            contents.add(new CellContent("iconAccion",
                    "delete",ColorCode.DELETE.value, true,
                    "deleteVolunter","Eliminar", null,
                    new ArrayList<CellParam>(Arrays.asList(
                            new CellParam("volunterId",volunter.getVolunter_id().toString())
                    ))));
            contents.add(new CellContent("iconAccion",
                    "remove_red_eye",ColorCode.VIEW.value, true,
                    "seeVolunter","Ver Info", null,
                    new ArrayList<CellParam>(Arrays.asList(
                            new CellParam("volunterId",volunter.getVolunter_id().toString())
                    ))));
        }

        return contents;
    }


    public Volunter findOneVolunter(Long volunter_id){
        return volunterRepository.getById(volunter_id);
    }

    public Volunter saveVolunter (Volunter volunter){
        System.out.println("llego service"+ volunter.getUser().getDni());
        userRepository.save(volunter.getUser());
        volunter.setStatus(Status.ACTIVO);
        return volunterRepository.save(volunter);
    }

    public void deleteVolunter(Long id){
        volunterRepository.deleteById(id);
    }

    public void exitVolunter(Long id){
        Volunter volunter=volunterRepository.getById(id);
        volunter.setStatus(Status.INACTIVO);
        volunter.setExit_date(new Date());
        volunterRepository.save(volunter);
    }

    public Volunter getVolunterById(Long id){
        Volunter volunter=volunterRepository.getById(id);
        /*volunter.setStatus(Status.ACTIVO);
        volunter.setEntry_date(new Date());
        volunterRepository.save(volunter);*/
        return volunter;
    }

    public Volunter updateVolunter (Volunter volunter){
        userRepository.save(volunter.getUser());
        return volunterRepository.save(volunter);
    }

    public Volunter findVolunterRoles(String email) {
        System.out.println("email"+email);
        User user = userRepository.findByEmail(email).get();
        System.out.println("Se encontro persona " + user.getName() + user.getLastname() + user.getUserId());
        Optional<Volunter> volunter=volunterRepository.findById(2123123L);

        return volunter.get();
    }
}
