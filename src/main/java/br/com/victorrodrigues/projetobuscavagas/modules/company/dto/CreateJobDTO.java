package br.com.victorrodrigues.projetobuscavagas.modules.company.dto;

import lombok.Data;

@Data
public class CreateJobDTO {
   private String level;
   private String description;
   private String benefits;
}
