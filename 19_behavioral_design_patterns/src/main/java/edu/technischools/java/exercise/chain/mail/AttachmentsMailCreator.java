/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java.exercise.chain.mail;

public class AttachmentsMailCreator implements MailPartCreator{

  private String attachment;

  public AttachmentsMailCreator(String attachment) {
    this.attachment = attachment;
  }

  @Override
  public Mail createMailPart(Mail mail, MailCreatorChain chain) {

    mail.getAttachments().add(this.attachment);

    return chain.doCreateMailPart(mail);
  }
}
