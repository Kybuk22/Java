/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java.exercise.chain.mail;

public abstract class GenericMailCreator implements MailPartCreator {


  protected abstract Mail createPart(Mail mail);


  @Override
  public Mail createMailPart(Mail mail, MailCreatorChain chain) {

    Mail part = createPart(mail);

    return chain.doCreateMailPart(part);
  }
}
