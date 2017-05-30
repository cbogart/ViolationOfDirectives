package main.com.directiveStudy

import com.intellij.execution.filters.TextConsoleBuilderFactory
import com.intellij.execution.ui.ConsoleViewContentType
import com.intellij.openapi.actionSystem._
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages
import com.intellij.psi.PsiClass

/**
  * Created by ZFC on 5/8/2017.
  */
class Main extends AnAction("Test _Directives": String) {


  override def actionPerformed(event: AnActionEvent): Unit = {
    val project = event.getData(CommonDataKeys.PROJECT)
    /*val fileEditor = event.getDataContext.getData(PlatformDataKeys.FILE_EDITOR)
    val txt = Messages.showInputDialog(project, "What is your name?","Input your name",Messages.getQuestionIcon)
    Messages.showMessageDialog(project, "Hello " + txt + "!\n I'm glad to see you.","Information",Messages.getInformationIcon)
    */
    println("running the plugin")
    val psiFile = event.getData(CommonDataKeys.PSI_FILE)
    //val project = event.getData(PlatformDataKeys.PROJECT_CONTEXT)
    val editor = event.getData(PlatformDataKeys.FILE_EDITOR)
    if (editor == null || psiFile == null){
      if (editor == null) {
        Messages.showMessageDialog(project, "Editor is null", "Null Info", Messages.getInformationIcon)
      } else {
        Messages.showMessageDialog(project, "PSI file is null", "Null Info", Messages.getInformationIcon)
      }
      //event.getPresentation.setEnabled(false)
    }
    else {
      val psiChildren = psiFile.getChildren
      println(psiChildren.length)
      var p = 0
      //this used to be a for loop but for some reason, the for loop stopped working after a while - makes no sense - maybe I upgraded to a broken version?
      while (p < psiChildren.length){
        val psiChild = psiChildren(p)
        psiChild match {
          case psiChild: PsiClass => testOptionsMenuIsCorrectlyOverriden(psiChild, project)
          case _ => ()
        }
        p = p + 1
      }
    }
  }

  def testOptionsMenuIsCorrectlyOverriden(pClass: PsiClass, project: Project): Unit = {
    val console = TextConsoleBuilderFactory.getInstance.createBuilder(project).getConsole
    val methods = pClass.getMethods()
    var hasOnCreateOptionsMenu = false
    var hasSetHasOptionsMenuTrue = false
    var inOnCreate = false
    var i = 0
    while( i < methods.length ){
      val m = methods(i)
      if(m.getName == "onCreateOptionsMenu"){
        hasOnCreateOptionsMenu = true
        inOnCreate = false
      } else if (m.getName == "onCreate") {
        inOnCreate = true
      } else {
        inOnCreate = false
      }
      var currentElement = m.getBody.getFirstBodyElement
      var hasNextSibling = true
      while(hasNextSibling){
        if (inOnCreate && currentElement.getFirstChild != null && currentElement.getFirstChild.getText == "setHasOptionsMenu(true)"){
          hasSetHasOptionsMenuTrue = true
        }
        if (currentElement.getNextSibling == null) {
          hasNextSibling = false
        } else {
          currentElement = currentElement.getNextSibling
        }
      }

      i = i + 1
      console.print(currentElement.getText, ConsoleViewContentType.NORMAL_OUTPUT)
    }
    if(hasOnCreateOptionsMenu && !hasSetHasOptionsMenuTrue){
      Messages.showMessageDialog(project, "hasSetOptionsMenu(true) must be called in onCreate to override onCreateOptionsMenu", "onCreateOptionsMenu error", Messages.getErrorIcon)
    }
    else {
      Messages.showMessageDialog(project, "The file is fine", "File check complete", Messages.getInformationIcon)
    }



  }
/*
  override def update(e: AnActionEvent): Unit = {
    super.update(e)
    val editor = e.getData(PlatformDataKeys.FILE_EDITOR)
    val psiFile = e.getData(LangDataKeys.TARGET_PSI_ELEMENT).getContainingFile
    val project = e.getData(PlatformDataKeys.PROJECT_CONTEXT)
    if (editor == null || psiFile == null){
      if (editor == null) {
        Messages.showMessageDialog(project, "Editor is null", "Null Info", Messages.getInformationIcon)
      } else {
        Messages.showMessageDialog(project, "PSI file is null", "Null Info", Messages.getInformationIcon)
      }
      e.getPresentation.setEnabled(false)
    }
    else {
      val psiChildren = psiFile.getChildren
      for (p <- 0 until psiChildren.length) {
        Messages.showMessageDialog(project, p.toString, "PSI Child", Messages.getInformationIcon)
      }
    }
  }
  */
}
