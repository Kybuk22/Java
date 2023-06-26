/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java.exercise.chain.mail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MailCreatorChain {

  List<MailPartCreator> mailParts = new ArrayList<>();
  private int index = 0;

  public MailCreatorChain() {
  }

  public void addMailPart(MailPartCreator mailPartCreator) {
    this.mailParts.add(mailPartCreator);
  }

  // var -args
  public void addMailParts(MailPartCreator... mailPartCreators){
    this.mailParts.addAll(Arrays.asList(mailPartCreators));
  }


  public Mail doCreateMailPart(Mail mail) {
    if (index < this.mailParts.size()) {

      return this.mailParts.get(index++).createMailPart(mail, this);
    }
    
    return mail;
  }
}
